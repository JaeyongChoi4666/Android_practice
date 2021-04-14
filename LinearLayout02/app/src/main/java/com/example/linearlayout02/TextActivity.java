package com.example.linearlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {
    TextView tv, cb_text;
    ImageView img1;
    RadioButton rb1, rb2, rb3;
    CheckBox[] cbs = new CheckBox[3];
    int[] cbIds = {R.id.cb1,R.id.cb2,R.id.cb3};
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        tv = findViewById(R.id.textView_1);
        tv.setTextColor(Color.DKGRAY);

        img1=findViewById(R.id.img1);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.levi);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.eren);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.micasa);
            }
        });

        cb_text=findViewById(R.id.cb_text);
        cb_text.setText(str);

        for(int i=0;i<cbs.length;i++){
            final int idx=i;
            cbs[i]=findViewById(cbIds[i]);
            cbs[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String cbStr=cbs[idx].getText().toString();
                    if(isChecked){
                        str+=cbStr;
                    }else{
                        str=str.replace(cbStr,"");
                    }
                    cb_text.setText(str);
                }
            });
        }


    }

    public void tvOnClicked(View view){
        TextView tv = (TextView)view;
        tv.setText("텍스트뷰 클릭");
    }
    public void btnOnClicked(View view){
        Button btn = (Button)view;
        btn.setText("버튼 클릭");
    }
}