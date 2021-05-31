package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        if(v==btn1){
           inflater.inflate(R.menu.menu1,menu);
        }
        if(v==btn2){
            inflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu1,menu);
        menu.add(0,1,0,"빨강");
        menu.add(0,2,0,"파랑");
        menu.add(0,3,0,"노랑");
        SubMenu subMenu=menu.addSubMenu("버튼모양 변경");
        subMenu.add(0,4,0,"확대");
        subMenu.add(0,5,0,"축소");
        subMenu.add(0,6,0,"회전");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        float xsize=btn1.getScaleX();
        float ysize=btn1.getScaleX();
        int degree=0;
        switch (item.getItemId()){
            case 1:
                btn1.setBackgroundColor(Color.RED);
                break;
            case 2:
                btn1.setBackgroundColor(Color.BLUE);
                break;
            case 3:
                btn1.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                btn1.setScaleX(xsize*2);
                btn1.setScaleY(ysize*2);
                break;
            case 5:

                btn1.setScaleX((float) (xsize*0.5));
                btn1.setScaleY((float) (ysize*0.5));
                break;
            case 6:
                degree+=45;
                btn1.setRotation(degree);
                break;
        }
        return true;
    }
}