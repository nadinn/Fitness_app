package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Measure;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "com.example.nadin.fitness_app.DataInput";
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
        //method for retrieving all the data stored in the database
    public ArrayList<Measures> getAllWeight(){
        ArrayList<Measures> measuresArrayList = new ArrayList<>();
        mSqLiteDatabse = this.getReadableDatabase();
        String select_all= "Select * from " + TABLE_NAME;
        Cursor cursor= mSqLiteDatabse.rawQuery(select_all,null);
        //checking the presence of the first row
        if (cursor.moveToFirst()){
            // do while loop for getting only the first row
            do {
                Measures measures = new Measures(cursor.getInt(0),cursor.getString(1), cursor.getString(2) );
                measuresArrayList.add(measures);


            } while(cursor.moveToNext()); //continue while cursor.moveToNext returns true


        }


        mSqLiteDatabse.close();
        return measuresArrayList;
    }



}
