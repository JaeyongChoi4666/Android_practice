package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);
        ed1=findViewById(R.id.edSender);
        ed2=findViewById(R.id.edContents);
        ed3=findViewById(R.id.edDate);
        btn=findViewById(R.id.button2);
        Intent intent=getIntent();
        processIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent){
        if(intent!=null){
            String sender=intent.getStringExtra("sender");
            String contents=intent.getStringExtra("contents");
            String receivedDate=intent.getStringExtra("receivedDate");
            ed1.setText(sender);
            ed2.setText(contents);
            ed3.setText(receivedDate);
        }
    }
}