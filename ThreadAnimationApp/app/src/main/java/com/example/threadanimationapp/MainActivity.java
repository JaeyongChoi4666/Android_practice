package com.example.threadanimationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn1, btn2;
    ImageView imageView;
    MainHandler handler;
//    Handler handler=new Handler();
    ArrayList<Drawable> list1=new ArrayList<Drawable>();
    Thread thread;
    int index=0;
    AniTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res=getResources();
        list1.add(res.getDrawable(R.drawable.face1));
        list1.add(res.getDrawable(R.drawable.face2));
        list1.add(res.getDrawable(R.drawable.face3));
        list1.add(res.getDrawable(R.drawable.face4));
        list1.add(res.getDrawable(R.drawable.face5));
        editText=findViewById(R.id.edText);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        imageView=findViewById(R.id.imageView);
        handler=new MainHandler();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread=new AniThread();
                thread.start();
//                task=new AniTask();
//                task.execute(editText.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.interrupt();
//                task.cancel(true);
            }
        });
    }

    class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle=msg.getData();
            imageView.setImageDrawable(list1.get(bundle.getInt("index")));
        }
    }

    class AniTask extends AsyncTask<String,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            index=0;
            imageView.setImageDrawable(list1.get(index));
        }

        @Override
        protected Integer doInBackground(String... strings) {
            Log.i("main Thread Data:",strings[0]);
            while (true){
                index++;
                if(index>4){
                    index=0;
                }
                publishProgress(index);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    break;
                }
            }
            return index;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            imageView.setImageDrawable(list1.get(values[0]));
        }
        @Override
        protected void onCancelled() {
            imageView.setImageDrawable(list1.get(0));
        }
    }

    class AniThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                final Drawable drawable=list1.get(index);
                index++;
                if(index>4){
                    index=0;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });
//                Message msg=handler.obtainMessage();
//                Bundle bundle=new Bundle();
//                bundle.putInt("index",index);
//                msg.setData(bundle);
//                handler.sendMessage(msg);

                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    break;
                }
            }
        }
    }
}