package com.example.electionapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CandidateAdapter extends PagerAdapter {
    LayoutInflater inflater;

    public CandidateAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=inflater.inflate(R.layout.picturelayout, null);
        ImageView img=(ImageView)view.findViewById(R.id.candidatePicture);
        img.setImageResource(R.drawable.masteryi+position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
