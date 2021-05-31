package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MypagerAdapter extends FragmentStatePagerAdapter {

    public MypagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MypagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return PagerFragment.create(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
