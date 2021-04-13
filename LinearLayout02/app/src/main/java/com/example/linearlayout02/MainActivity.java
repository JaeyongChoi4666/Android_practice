package com.example.linearlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add_btn, sub_btn, mul_btn, div_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn=findViewById(R.id.add_button);
        sub_btn=findViewById(R.id.sub_button);
        mul_btn=findViewById(R.id.mul_button);
        div_btn=findViewById(R.id.div_button);

        Object first_num = findViewById(R.id.first_number);
        Object second_num = findViewById(R.id.first_number);
    }
}