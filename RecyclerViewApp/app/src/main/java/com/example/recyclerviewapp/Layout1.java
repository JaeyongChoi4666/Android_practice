package com.example.recyclerviewapp;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView tvName,tvPhone;


    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public Layout1(Context context) {
        super(context);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1,this,true);
        imageView=findViewById(R.id.imageView);
        tvName=findViewById(R.id.tvName);
        tvPhone=findViewById(R.id.tvPhone);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
    public void setName(String name){
        tvName.setText(name);
    }
    public void setTvPhone(String phone){
        tvPhone.setText(phone);
    }
}
