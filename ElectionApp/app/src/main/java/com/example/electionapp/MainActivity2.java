package com.example.electionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.electionapp.ui.progress.ProgressFragment;
import com.example.electionapp.ui.home.HomeFragment;
import com.example.electionapp.ui.close.CloseFragment;
import com.example.electionapp.vo.Member;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity2 extends AppCompatActivity {
    private BottomNavigationView mBottomNV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBottomNV=findViewById(R.id.nav_view);

        BottomNavigate(R.id.navUser);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                BottomNavigate(item.getItemId());
                return true;
            }
        });
    }

    private void BottomNavigate(int id){
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }
        Intent intent=getIntent();
        String member_id=intent.getStringExtra("member_id");
        String univ_name=intent.getStringExtra("univ_name");
        String dept_name=intent.getStringExtra("dept_name");
        String member_name=intent.getStringExtra("member_name");
        String member_number=intent.getStringExtra("member_number");
        String member_grade=intent.getStringExtra("member_grade");

        Bundle bundle=new Bundle();
        bundle.putString("member_id",member_id);
        bundle.putString("univ_name",univ_name);
        bundle.putString("dept_name",dept_name);
        bundle.putString("member_name",member_name);
        bundle.putString("member_number",member_number);
        bundle.putString("member_grade",member_grade);

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.navUser) {
                fragment = new HomeFragment();
                fragment.setArguments(bundle);
            } else if (id == R.id.navProgress){
                fragment = new ProgressFragment();
                fragment.setArguments(bundle);
            }else {
                fragment = new CloseFragment();
                fragment.setArguments(bundle);
            }
            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();
    }
}