package com.example.viewpagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomerAdapter extends PagerAdapter {
    LayoutInflater inflater;

    public CustomerAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=inflater.inflate(R.layout.layout1,null);
        ImageView imageView=view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.pic1+position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
