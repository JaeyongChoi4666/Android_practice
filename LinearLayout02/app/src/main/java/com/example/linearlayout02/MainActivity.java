package com.example.linearlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] btn = new Button[4];
    int[] ids = {R.id.add_button,R.id.sub_button,R.id.mul_button,R.id.div_button};
    EditText stNum, ndNum;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout);

        stNum = findViewById(R.id.first_number);
        ndNum = findViewById(R.id.second_number);

        res = findViewById(R.id.result_number);

        for(int i=0;i<btn.length;i++){
            final int idx = i;
            btn[i]=findViewById(ids[i]);
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num1 = Integer.parseInt(stNum.getText().toString());
                    int num2 = Integer.parseInt(ndNum.getText().toString());
                    int result = 0;
                    switch (ids[idx]){
                        case R.id.add_button: result = num1+num2; break;
                        case R.id.sub_button: result = num1-num2; break;
                        case R.id.mul_button: result = num1*num2; break;
                        case R.id.div_button: result = num1/num2; break;
                    }
                    res.setText(result+"");
                }
            });
        }
    }

    public void Onclick(View view){
        int num1 = Integer.parseInt(stNum.getText().toString());
        int num2 = Integer.parseInt(ndNum.getText().toString());
        int result = 0;
        switch (view.getId()){
            case R.id.add_button: result = num1+num2; break;
            case R.id.sub_button: result = num1-num2; break;
            case R.id.mul_button: result = num1*num2; break;
            case R.id.div_button: result = num1/num2; break;
        }
        res.setText(result+"");
    }
}