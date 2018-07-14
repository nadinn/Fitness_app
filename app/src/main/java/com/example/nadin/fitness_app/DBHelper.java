package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DataInput";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Input_Table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME ";
    private static final String COL_DATE = "DATE";
    SQLiteDatabase mSqLiteDatabse;

    public DBHelper (Context context) {super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY, " + COL_NAME + " TEXT, " + COL_DATE + " TEXT ); ";

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertWeight(String dbWeight, String dbDate){
        mSqLiteDatabse = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, dbWeight);
        values.put(COL_DATE, dbDate);
        //insert a single row of data into the database
        mSqLiteDatabse.insert(TABLE_NAME, null, values);
        //closing the database
        mSqLiteDatabse.close();



    }



}
