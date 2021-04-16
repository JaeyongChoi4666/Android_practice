package com.example.eventapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    int x,y;
    String str="이벤트 없음";
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.GREEN);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();
        if(event.getAction()==MotionEvent.ACTION_DOWN)
            str="ACTION_DOWN";
        if(event.getAction()==MotionEvent.ACTION_MOVE)
            str="ACTION_MOVE";
        if(event.getAction()==MotionEvent.ACTION_UP)
            str="ACTION_UP";
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(x,y,x+100,y+100,paint);
        paint.setTextSize(60);
        canvas.drawText(str,0,60,paint);
    }
}
