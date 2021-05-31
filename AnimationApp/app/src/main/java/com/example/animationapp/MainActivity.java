package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
    }

    public void mOnClicked(View view){
        switch (view.getId()){
            case R.id.button1:animation= AnimationUtils.loadAnimation(this,R.anim.scale);break;
            case R.id.button2:animation= AnimationUtils.loadAnimation(this,R.anim.translate);break;
            case R.id.button3:
            case R.id.button4:
        }
        imageView.startAnimation(animation);
    }
}