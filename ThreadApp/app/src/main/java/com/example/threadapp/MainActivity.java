package com.example.threadapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int value=0;
    TextView tv;
    Button btn;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textView);
        btn=findViewById(R.id.button);

        handler=new MainHandler();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(new BackgroundThread());
                thread.start();
            }
        });
    }

    class MainHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            int value=bundle.getInt("value");
            tv.setText("value 값:"+value);
        }
    }

    class BackgroundThread implements Runnable{

        @Override
        public void run() {
            for(int i=0; i<30;i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
                Log.i("Thread","value="+value);
                //tv.setText("value:"+value);
                value++;
                Message msg=handler.obtainMessage();
                Bundle bundle=new Bundle();
                bundle.putInt("value",value);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }
    }

//    class BackgroundThread extends Thread{
//        @Override
//        public void run() {
//            for(int i=0; i<30;i++){
//                try{
//                    Thread.sleep(1000);
//                }catch (Exception e){}
//                Log.i("Thread","value="+value);
//                //tv.setText("value:"+value);
//                value++;
//            }
//        }
//    }
}