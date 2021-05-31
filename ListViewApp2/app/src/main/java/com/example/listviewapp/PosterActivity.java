package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PosterActivity extends AppCompatActivity {
    int[] imgIds={R.drawable.mov04,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov35,R.drawable.mov37};
    TextView textView;
    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);
        textView=findViewById(R.id.textView2);
        imageView=findViewById(R.id.imageView);
        btn=findViewById(R.id.button);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        int position=intent.getIntExtra("position", 0);
        textView.setText(title);
        imageView.setImageResource(imgIds[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}