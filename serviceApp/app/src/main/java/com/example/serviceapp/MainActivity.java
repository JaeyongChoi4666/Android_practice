package com.example.serviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    Button btn, btn2;
    EditText ed1, edSender, edContents, edDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.serviceBtn);
        ed1=findViewById(R.id.editTextTextPersonName);
        edSender=findViewById(R.id.edSender);
        edContents=findViewById(R.id.edContents);
        edDate=findViewById(R.id.edDate);
        btn2=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("name",ed1.getText().toString());
                intent.putExtra("command","show");
                startService(intent);
            }
        });
        AutoPermissions.Companion.loadAllPermissions(this,101);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if(intent!=null){
            String command=intent.getStringExtra("command");
            String name=intent.getStringExtra("name");
            Toast.makeText(this,command+", "+name,Toast.LENGTH_SHORT).show();
        }
        super.onNewIntent(intent);
        processIntent(intent);
    }

    public void processIntent(Intent intent){
        if(intent!=null){
            String sender=intent.getStringExtra("sender");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);
    }

    @Override
    public void onDenied(int i, String[] strings) {
     Toast.makeText(this,"permissions denied:"+strings.length,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(this,"permissions granted:"+strings.length,Toast.LENGTH_SHORT).show();
    }
}