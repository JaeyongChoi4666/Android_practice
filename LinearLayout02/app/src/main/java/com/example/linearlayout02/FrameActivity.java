package com.example.linearlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {
    Button prevBtn, nextBtn;
    int[] ids = {R.id.levi,R.id.eren,R.id.micasa};
    ImageView[] iv = new ImageView[3];
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        prevBtn = findViewById(R.id.prev_btn);
        nextBtn = findViewById(R.id.next_btn);

        for(int i=0;i<iv.length;i++){
            iv[i] = findViewById(ids[i]);
            if(i!=0){
                iv[i].setVisibility(View.INVISIBLE);
           }
        }
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<iv.length-1){
                    iv[i].setVisibility(View.INVISIBLE);
                    i++;
                    iv[i].setVisibility(View.VISIBLE);
                }else if(i==iv.length-1){
                    iv[i].setVisibility(View.INVISIBLE);
                    i=0;
                    iv[i].setVisibility(View.VISIBLE);
                }
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0){
                    iv[i].setVisibility(View.INVISIBLE);
                    i--;
                    iv[i].setVisibility(View.VISIBLE);
                }else if(i==0){
                    iv[i].setVisibility(View.INVISIBLE);
                    i=iv.length-1;
                    iv[i].setVisibility(View.VISIBLE);
                }
            }
        });
    }
}