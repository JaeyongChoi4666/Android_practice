package com.example.dbrecyclerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MovieDetailApp extends AppCompatActivity {
    MovieDBHelper helper;
    SQLiteDatabase database;
    EditText edTitle, edPoint, edDirector,edActor;
    TextView textView;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail_app);
        edTitle=findViewById(R.id.edTitle);
        edPoint=findViewById(R.id.edPoint);
        edDirector=findViewById(R.id.edDirector);
        edActor=findViewById(R.id.edActor);
        textView=findViewById(R.id.detail);

        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        helper=new MovieDBHelper(this);
        if(id>0){
            database=helper.getReadableDatabase();
            String sql="select * from "+helper.tableName+" where id="+id;
            Cursor cursor=database.rawQuery(sql,null);
            cursor.moveToNext();
            edTitle.setText(cursor.getString(1));
            edPoint.setText(cursor.getDouble(2)+"");
            edDirector.setText(cursor.getString(3));
            edActor.setText(cursor.getString(4));
        }
    }

    public void mOnClicked(View view){
        switch (view.getId()){
            case R.id.btnInsert:
                dataInsert();
                break;
            case R.id.btnUpdate:
                dataUpdate();
                break;
            case R.id.btnDelete:
                dataDelete();
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }

    private void dataInsert(){
        database=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title",edTitle.getText().toString());
        values.put("point",Double.parseDouble(edPoint.getText().toString()));
        values.put("director",edDirector.getText().toString());
        values.put("actors",edActor.getText().toString());
        values.put("resId", Data.resIds[0]);
        database.insert(helper.tableName,null,values);
    }
    private void dataUpdate(){

    }
    private void dataDelete(){

    }
    private void init(){

    }
}