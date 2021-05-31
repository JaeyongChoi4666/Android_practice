package com.example.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    int value;
    ProgressBar progressBar;
    Button btn1, btn2;
    BackgroundTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task=new BackgroundTask();
                task.execute(5);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPostExecute(Integer integer) {
            value=0;
            progressBar.setProgress(value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int n=integers[0];
            while (isCancelled()==false){
                value+=n;
                if(value>=100){
                    break;
                }else{
                    publishProgress(value);
                }
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){}
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPreExecute() {
            progressBar.setProgress(0);
        }

        @Override
        protected void onCancelled() {
            progressBar.setProgress(0);
        }
    }
}