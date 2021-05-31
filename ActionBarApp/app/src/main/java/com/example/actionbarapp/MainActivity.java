package com.example.actionbarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tV;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV=findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu1,menu);
        View v=menu.findItem(R.id.menu_search).getActionView();
        if(v!=null){
            EditText editText=v.findViewById(R.id.edText);
            if(editText!=null){

            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_refresh:
                tV.setText("새로고침");
                break;
            case R.id.menu_search:
                tV.setText("검색");
                break;
            case R.id.menu_setting:
                tV.setText("설정");
                break;
        }
            
        return true;
    }
}