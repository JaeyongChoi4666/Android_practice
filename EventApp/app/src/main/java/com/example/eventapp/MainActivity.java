package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    EditText edNum1, edNum2;
    TextView tv;
    Button[] btns = new Button[4];
    int[] btnIds = {R.id.addbtn,R.id.subbtn,R.id.mulbtn,R.id.divbtn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        tv = findViewById(R.id.textView);
//        MyLister lister = new MyLister();
        for(int i=0;i<btns.length;i++){
            btns[i]=findViewById(btnIds[i]);
            btns[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int num1=Integer.parseInt(edNum1.getText().toString());
        int num2=Integer.parseInt(edNum2.getText().toString());
        int result=0;
        switch (v.getId()){
            case R.id.addbtn: result=num1+num2; break;
            case R.id.subbtn: result=num1-num2; break;
            case R.id.mulbtn: result=num1*num2; break;
            case R.id.divbtn: result=num1/num2; break;
        }
        tv.setText("계산결과 : "+result);
    }

//    class MyLister implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            int num1=Integer.parseInt(edNum1.getText().toString());
//            int num2=Integer.parseInt(edNum2.getText().toString());
//            int result=0;
//            switch (v.getId()){
//                case R.id.addbtn: result=num1+num2; break;
//                case R.id.subbtn: result=num1-num2; break;
//                case R.id.mulbtn: result=num1*num2; break;
//                case R.id.divbtn: result=num1/num2; break;
//            }
//            tv.setText("계산결과 : "+result);
//        }
//    }


//    public void btnOnClicked(View view){
//        int num1=Integer.parseInt(edNum1.getText().toString());
//        int num2=Integer.parseInt(edNum2.getText().toString());
//        int result=0;
//        switch (view.getId()){
//            case R.id.addbtn: result=num1+num2; break;
//            case R.id.subbtn: result=num1-num2; break;
//            case R.id.mulbtn: result=num1*num2; break;
//            case R.id.divbtn: result=num1/num2; break;
//        }
//        tv.setText("계산결과 : "+result);
//    }
}