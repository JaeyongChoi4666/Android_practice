package com.example.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    EditText edID, edPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btn=findViewById(R.id.btnOpen);
        edID=findViewById(R.id.edID);
        edPW=findViewById(R.id.edPW);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("id",edID.getText());
                intent.putExtra("pw",edPW.getText());
                startActivity(intent);
            }
        });
    }
}