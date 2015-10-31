# Consuming-Restful-in-android
Follow the below steps to consume RestFul in android. In this tutorial i will use the restFul webservices to validate login credentials. If user is valid it will go to the welcome page else it will be in same page.
##Step1
Create a android blank project, if you don’t know how to create blank project in android check my [previous post](http://javaant.com/hello-world-using-android-studio-1-0/#.VjTPzPkrLIV).
##Step2
Need internet access permission. write the below code in AndroidManifest.xml file.
```json
 <uses-permission android:name="android.permission.INTERNET">
</uses-permission>
```
##Step3
Need RestFul url which is running in another server or same machine.
##Step4
Make a RestFul Client which will extends AsyncTask. See RestFulPost.java.
##Step5
Make DTO class for RestFull Request data and RestFul Response.

For more details see my [original post](http://javaant.com/consume-a-restful-webservice-in-android/#.VjTQ4PkrLIU)
