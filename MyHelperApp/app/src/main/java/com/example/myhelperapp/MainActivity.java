package com.example.myhelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edName, edAge, edMobile;
    TextView Result;
    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=findViewById(R.id.edName);
        edAge=findViewById(R.id.edAge);
        edMobile=findViewById(R.id.edMobile);
        Result=findViewById(R.id.tvResult);
        dbHelper=new DatabaseHelper(this);
    }
    public void mOnClicked(View view){
        switch (view.getId()){
            case R.id.btnInsert:
                dataInsert();
                break;
            case R.id.btnSelect:
                dataSelect();
                break;
            case R.id.btnSearch:
                dataSearch();
                break;
            case R.id.btnUpdate:
                dataUpdate();
                break;
            case R.id.btnDelete:
                dataDelete();
                break;
        }
    }

    private void dataInsert(){
        println("dataInsert 호출");
        database=dbHelper.getWritableDatabase();
        String name=edName.getText().toString();
        int age=Integer.parseInt(edAge.getText().toString());
        String mobile=edMobile.getText().toString();
//        String sql="insert into "+dbHelper.TABLE_NAME+"(name,age,mobile) " +
//                "values('"+name+"',"+age+",'"+mobile+"')";
//        database.execSQL(sql);
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("age",age);
        values.put("mobile",mobile);
        database.insert(dbHelper.TABLE_NAME,null,values);

        println("레코드 추가");
    }
    private void dataSelect(){
        println("dataSelect 호출");
        database=dbHelper.getReadableDatabase();
        String sql="select * from "+dbHelper.TABLE_NAME;
        Cursor cursor=database.rawQuery(sql,null);
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String mobile=cursor.getString(3);
            println(id+", "+name+", "+age+", "+mobile);
        }

    }
    private  void dataSearch(){
        println("dataSearch 호출");
        database=dbHelper.getReadableDatabase();
        String name=edName.getText().toString();
        String sql="select * from "+dbHelper.TABLE_NAME+" where name='"+name+"'";
        Cursor cursor=database.rawQuery(sql,null);
        cursor.moveToNext();
        edName.setText(cursor.getString(1));
        edAge.setText(cursor.getInt(2)+"");
        edMobile.setText(cursor.getString(3));
    }

    private void dataUpdate(){
        println("dataUpdate 호출");
        database=dbHelper.getWritableDatabase();
        String name=edName.getText().toString();
        int age=Integer.parseInt(edAge.getText().toString());
        String mobile=edMobile.getText().toString();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("age",age);
        values.put("mobile",mobile);
        database.update(dbHelper.TABLE_NAME,values,"name=?",new String[]{name});
    }
    private void dataDelete(){
        println("dataDelete 호출");

    }

    private void println(String string){
        Result.append(string+"\n");
    }
}