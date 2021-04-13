package com.example.test02app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClicked(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.button1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-1234"));
                startActivity(intent);
                break;
        }
    }
}