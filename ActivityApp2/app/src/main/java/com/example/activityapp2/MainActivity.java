package com.example.activityapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInput, btnOutput;
    String name,phone;
    int age;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            name=data.getStringExtra("name");
            age=data.getIntExtra("age",0);
            phone=data.getStringExtra("phone");

            Toast.makeText(this,name+age+phone,Toast.LENGTH_SHORT).show();
        }else if(requestCode==200 && resultCode==RESULT_OK){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInput=findViewById(R.id.btnInput);
        btnOutput=findViewById(R.id.btnOutput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),InputActivity.class);
                startActivityForResult(intent,100);
            }
        });
        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),OutputActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("age",age);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });


    }
}