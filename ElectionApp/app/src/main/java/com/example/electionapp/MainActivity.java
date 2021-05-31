package com.example.electionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=findViewById(R.id.btnLogin);
        btnJoin=findViewById(R.id.btnJoin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent joinIntent=new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(joinIntent);
            }
        });
    }
}