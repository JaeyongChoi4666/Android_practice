package com.example.dbrecyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    MovieDBHelper movieDBHelper;
    SQLiteDatabase database;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView1);
        btn=findViewById(R.id.button);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MovieAdapter();
        movieDBHelper=new MovieDBHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MovieDetailApp.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        database=movieDBHelper.getReadableDatabase();
        ArrayList<Movie> items=new ArrayList<Movie>();
        String sql="select * from "+movieDBHelper.tableName;
        Cursor cursor=database.rawQuery(sql,null);
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            int id=cursor.getInt(0);
            String title=cursor.getString(1);
            double point=cursor.getDouble(2);
            String director=cursor.getString(3);
            String actors=cursor.getString(4);
            int resId=cursor.getInt(5);
            Movie item=new Movie(id,title,point,director,actors,resId);
            items.add(item);
        }
        adapter.setItems(items);
        recyclerView.setAdapter(adapter);
    }

}