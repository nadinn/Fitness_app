package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import java.util.ArrayList;

public class DBHelper1 extends SQLiteOpenHelper {

    SQLiteDatabase mmSqLiteDatabase;
    private Context con;

    public DBHelper1(Context context) {
        super(context, "TestDatabase", null, 1);
        con = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table MyTable (xValues INTEGER, yValues INTEGER);";
        db.execSQL(create_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "MyTable");
        onCreate(db);
    }

    public void insertData(int x, int y) {
        mmSqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("xValues", x);
        values.put("yValues", y);
        //insert a single row of data into the database
        mmSqLiteDatabase.insert("MyTable", null, values);

        //closing the database
        //mSqLiteDatabase.close();

    }


}
