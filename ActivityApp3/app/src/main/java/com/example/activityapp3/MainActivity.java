package com.example.activityapp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    TextView tV;
    Button btn;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editTextNumber1);
        ed2=findViewById(R.id.editTextNumber2);
        tV=findViewById(R.id.textView);
        btn=findViewById(R.id.button);
        rg=findViewById(R.id.rg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=Integer.parseInt(ed1.getText().toString());
                int num2=Integer.parseInt(ed2.getText().toString());
                String op="";
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.raadd : op="+";break;
                    case R.id.rasub : op="-";break;
                    case R.id.ramul : op="*";break;
                    case R.id.radiv : op="/";break;
                }
                Intent intent=new Intent(getApplicationContext(),CalcActivity.class);
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                intent.putExtra("op",op);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}