package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    ViewPager pager;
    MypagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pager=findViewById(R.id.viewpager2);
        adapter=new MypagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }
}