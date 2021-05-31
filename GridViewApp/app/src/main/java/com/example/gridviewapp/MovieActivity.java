package com.example.gridviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        textView=findViewById(R.id.MVtitle);
        imageView=findViewById(R.id.MVposter);
        editText=findViewById(R.id.edPoint);
        btn=findViewById(R.id.button);

        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("title"));
        imageView.setImageResource(intent.getIntExtra("imgId",0));
        final int position=intent.getIntExtra("position",0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point=Integer.parseInt(editText.getText().toString());
                Intent newIntent=new Intent(getApplicationContext(),MainActivity.class);
                newIntent.putExtra("point",point);
                newIntent.putExtra("position",position);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
                finish();
            }
        });
    }
}