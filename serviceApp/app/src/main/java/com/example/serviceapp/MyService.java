package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    final static String TAG="MyService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate 호출됨");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy 호출됨");
    }

    @Override //서비스에서 할 일을 정의
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand 호출됨");

        if(intent==null){
            return Service.START_STICKY;
        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        String command=intent.getStringExtra("command");
        String name=intent.getStringExtra("name");
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            Log.d(TAG,"waiting"+i+"seconds");
        }
        Intent showIntent=new Intent(getApplicationContext(), MainActivity.class);
        showIntent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_CLEAR_TOP|
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        showIntent.putExtra("command","from service command");
        showIntent.putExtra("name",name+"from service name");
        startActivity(showIntent);
    }
}