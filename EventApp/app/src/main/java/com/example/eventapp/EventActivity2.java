package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class EventActivity2 extends AppCompatActivity {
    int x,y;

    public class KeyView extends View {
        public KeyView(Context context) {
            super(context);
            setBackgroundColor(Color.parseColor("#F7EA48"));
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#CA3604"));
            canvas.drawRect(x,y,x+100,y+100,paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyView view= new MyView(this);
        KeyView view= new KeyView(this);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        setContentView(view);
        //setContentView(R.layout.activity_event2);
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_UP){

                    switch (keyCode){
                        case KeyEvent.KEYCODE_DPAD_LEFT:
                            if(x-20>=0){
                                x-=20;
                            } break;
                        case KeyEvent.KEYCODE_DPAD_RIGHT:
                            if(x+20<=view.getWidth()-100){
                                x+=20;
                            } break;
                        case KeyEvent.KEYCODE_DPAD_UP:
                            if(y-20>=0){
                                y-=20;
                            }  break;
                        case KeyEvent.KEYCODE_DPAD_DOWN:
                            if(y+20<=view.getHeight()-100){
                                y+=20;
                            }  break;
                    }
                    view.invalidate();
                    return true;
                }
                return false;
            }
        });
    }
}