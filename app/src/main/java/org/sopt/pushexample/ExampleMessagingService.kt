package org.sopt.pushexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelID = "notification_channel"
const val channelName = "org.sopt.pushExample"

class ExampleMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        // 서버에게 토큰 refresh 됐다고 알려주는 api 연동 구현하기
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage.data.isNotEmpty()) {
            /**
             * Check if message contains a data payload.
             * 푸시알림을 data 형식으로 받는다면, 여기서 처리
             * 아래와 같이 데이터가 오면
             *
             * val data = remoteMessage.data
             * val title = data["title"] 이렇게 사용할 수 있음
             *
             * data: {
                title: randomTitle as string,
                body: reminder.ogTitle as string,
                image: reminder.ogImage as string,
                url: reminder.url as string,
            }
             * */
        }

        remoteMessage.notification?.let {
            // Check if message contains a notification payload.
            // 푸시알림을 notification 형식으로 받는다면, 여기서 처리
            sendNotification(it.title!!, it.body!!)
        }
    }

    private fun sendNotification(title : String, text : String) {

        // 푸시알림 클릭 했을 때 이동할 Activity 지정
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setContent(getRemoteView(title,text))
            // 커스텀 토스트를 사용하지 않고, 안드로이드 디폴트 푸시알림을 사용하려면
            // 위 setContent() 한 줄을 지우고 setContentTitle(), setContentText()를 추가하면됨
            //.setContentTitle(title)
            //.setContentText(text)


        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        /** Oreo Version 이하일때 처리 하는 코드 */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    // 푸시알림 커스텀 하는 메소드
    private fun getRemoteView(title : String, text : String) : RemoteViews{
        val remoteView = RemoteViews("com.sopt.androidsharing", R.layout.push_notification)
        remoteView.setTextViewText(R.id.tv_title, title)
        remoteView.setTextViewText(R.id.tv_description, text)
        remoteView.setImageViewResource(R.id.iv_image, R.drawable.ic_launcher_foreground)

        return remoteView
    }

    companion object {
        private const val TAG = "ExampleMessagingService"
    }
}