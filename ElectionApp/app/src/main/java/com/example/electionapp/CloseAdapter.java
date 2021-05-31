package com.example.electionapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class CloseAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public CloseAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    void addItem(Fragment fragment) {
        fragments.add(fragment);
    }
}
