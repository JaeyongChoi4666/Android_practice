package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.viewPager1);
        CustomerAdapter adapter=new CustomerAdapter(getLayoutInflater());
        pager.setAdapter(adapter);
    }

    public void mOnClicked(View view){
        int position;
        switch (view.getId()){
            case R.id.prevBtn :
                position=pager.getCurrentItem();
                pager.setCurrentItem(position-1,true);
                break;
            case R.id.nextBtn :
                position=pager.getCurrentItem();
                pager.setCurrentItem(position+1,true);
                break;
        }
    }
}