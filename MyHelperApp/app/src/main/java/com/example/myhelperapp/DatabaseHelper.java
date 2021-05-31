package com.example.myhelperapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    String TAG="DatabaseHelper";
    String TABLE_NAME="emp";
    public static String NAME="employee.db";
    public static int VERSION=1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"onCreate 호출");
        String sql="create table if not exists "+TABLE_NAME+"(" +
                "_id integer PRIMARY KEY AUTOINCREMENT," +
                "name text," +
                "age integer," +
                "mobile text)";
        db.execSQL(sql);
        Log.i(TAG,"테이블 생성됨");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.i(TAG,"onOpen 호출");
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"onUpgrade 호출:"+oldVersion+"→"+newVersion);
        if(newVersion>1){
            db.execSQL("DROP table if exists "+TABLE_NAME);
            onCreate((db));
        }
    }
}
