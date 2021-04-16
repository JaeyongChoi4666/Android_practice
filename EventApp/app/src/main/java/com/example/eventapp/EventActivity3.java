package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class EventActivity3 extends AppCompatActivity {
    int x,y;
    String str ="";
    View upView, downView;
    TextView  resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        upView=findViewById(R.id.upView);
        downView=findViewById(R.id.downView);
        resultView=findViewById(R.id.textView);
        x=(int)event.getX();
        y=(int)event.getY();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            str = "("+x +","+ y+")에서 터치 발생";
        }
//        upView.invalidate();
//        downView.invalidate();
//        resultView.invalidate();

        resultView.append(str+"\n");
        return super.onTouchEvent(event);
    }
}