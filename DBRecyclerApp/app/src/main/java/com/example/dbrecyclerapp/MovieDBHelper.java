package com.example.dbrecyclerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MovieDBHelper extends SQLiteOpenHelper {
    public static String dbName="movie01.db";
    public String tableName="movie_table";
    public static int VERSION=1;
    String TAG="MovieDBHelper TAG";

    public MovieDBHelper(@Nullable Context context) {
        super(context, dbName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"onCreate 호출");
        String sql="create table if not exists "+tableName+"(" +
                "_id integer PRIMARY KEY autoincrement, " +
                "title text, " +
                "point double, " +
                "director text, " +
                "actors text, " +
                "resId integer)";
        db.execSQL(sql);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.i(TAG,"onOpen 호출");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"onUpgrade 호출");
    }
}
