package com.example.cproviderapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProviderHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="provider1.db";
    private static final int version=1;
    public static final String TABLE_NAME="person";
    public static final String PERSON_ID="_id";
    public static final String PERSON_NAME="name";
    public static final String PERSON_AGE="age";
    public static final String PERSON_MOBILE="mobile";
    public static final String[] ALL_COLUMNS={PERSON_ID,PERSON_NAME,PERSON_AGE,PERSON_MOBILE};


    public ProviderHelper(@Nullable Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+TABLE_NAME+"(" +
                PERSON_ID       +" integer PRIMARY KEY autoincrement,"+
                PERSON_NAME     +" text,"+
                PERSON_AGE      +" integer,"+
                PERSON_MOBILE   +" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
}
