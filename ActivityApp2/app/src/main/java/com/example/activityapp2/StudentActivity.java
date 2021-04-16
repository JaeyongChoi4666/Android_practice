package com.example.activityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentActivity extends AppCompatActivity {
    EditText edSno, edSname, edMajor;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        edSno=findViewById(R.id.editSno);
        edSname=findViewById(R.id.edName);
        edMajor=findViewById(R.id.edMajor);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setSno(Integer.parseInt(edSno.getText().toString()));
                student.setName(edSname.getText().toString());
                student.setMajor(edMajor.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("student",student);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}