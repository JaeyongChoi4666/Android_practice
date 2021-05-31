package com.example.recyclermovieapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubLayout extends LinearLayout {
    TextView textView;
    ImageView imageView;


    public SubLayout(Context context) {
        super(context);
        init(context);
    }

    public SubLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sublayout,this,true);
        textView=findViewById(R.id.textTitle);
        imageView=findViewById(R.id.imageView);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
    public void setName(String name){
        textView.setText(name);
    }
}
