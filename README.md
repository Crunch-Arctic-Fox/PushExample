# PushExample

### 📚 Reference
1. [FCM Overview](https://firebase.google.com/docs/cloud-messaging)
2. [FCM Android](https://firebase.google.com/docs/cloud-messaging/android/client)
3. [Android Developer](https://developer.android.com/guide/topics/ui/notifiers/notifications)

<br/>

### 📋 작업 순서
``` Text
1. Firebase 웹 들어가서 Project 생성한다

2. build & manifest(meta & service) 파일 수정해서 Firebase sdk를 설정해준다
     - bom을 사용하려면 minSDK가 26이상이었던것 같으니.. 잘 안되면 체크해보기
     
3. FirebaseMessagingService를 상속받는ExampleMessagingService class를 만들어 준다

4. onMessageRecieved 메소드를 오버라이딩 해준다 (notification, data 따로 처리)

5. 커스텀 뷰를 사용하고 싶다면 Relative layout을 사용해야만한다 (height값 제한 있음.. 44였나..)

6. 서버가 디바이스 토큰 달라고 하면 당황하지 않고 getDeviceToken() 메소드를 MainActivity의 onCreate()안에서 호출한다

7. onNewToken() 메소드 내에서FCM Devide Token이 Refresh되는 상황을 처리해준다.
```

### 💾 세미나 자료

[FCM Seminar pdf 초안](https://github.com/Crunch-Arctic-Fox/PushExample/files/8133392/FCM.Draft1.pdf)
------------------

![image](https://user-images.githubusercontent.com/59546818/155548347-cde3ede7-84d8-407d-8d4d-cd5f3b159a97.png)
------------------

![image](https://user-images.githubusercontent.com/59546818/155548370-d00b9324-c650-4ff5-a236-93f2f52b8b1a.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548385-ed9b3e33-c124-44e7-8ae5-57fa1fb0cd90.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548396-54b7dbdb-2fe8-4978-adb3-a725132eab4f.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548439-423aa5f8-84e4-41ed-a212-f4d6b0b55874.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548459-f6ba5858-d8df-4433-a244-b02c307a1e16.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548472-88bf70fd-1be5-494f-b11c-5dd9c8693264.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548483-d1b65adf-6040-47d0-af22-58f5fbe27c13.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548544-a98c55ec-7c67-4617-b31e-3c132fc1a9a1.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548559-116cdce7-a8dc-4912-9329-7b316e9a0107.png)
------------------
![image](https://user-images.githubusercontent.com/59546818/155548569-518fd5c0-f96f-44e6-8e8e-c55eab50fb33.png)
