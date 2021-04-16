package com.example.eventapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class KeyView extends View {
    int x,y;
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
