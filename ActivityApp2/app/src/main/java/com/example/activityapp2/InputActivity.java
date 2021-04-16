package com.example.activityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    EditText edName, edAge, edPhone;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edName=findViewById(R.id.edName);
        edAge=findViewById(R.id.edAge);
        edPhone=findViewById(R.id.edPhone);
        btn=findViewById(R.id.btnInsert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name",edName.getText().toString());
                intent.putExtra("age",edAge.getText());
                intent.putExtra("phone",edPhone.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}