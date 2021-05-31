package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    Layout1 layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        layout1=findViewById(R.id.layout1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setImage(R.drawable.profile1);
                layout1.setName("토니 스타크");
                layout1.setTvPhone("010-1111-1111");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setImage(R.drawable.profile2);
                layout1.setName("스티브 로저스");
                layout1.setTvPhone("010-2222-2222");
            }
        });
    }
}