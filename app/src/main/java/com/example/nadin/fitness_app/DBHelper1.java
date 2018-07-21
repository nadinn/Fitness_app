package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import java.util.ArrayList;

public class DBHelper1 extends SQLiteOpenHelper {

    private static final String DB_NAME = "DatabaseOne.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME1 = "Input_Table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME ";
    private static final String COL_DATE = "DATE";
    SQLiteDatabase mSqLiteDatabase;

    public DBHelper1 (Context context) {
        super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME1 + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT, " + COL_DATE + " TEXT ); ";

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1 );
        onCreate(db);
    }

    public boolean insertWeight(String dbWeight, String dbDate) {
        mSqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, dbWeight);
        values.put(COL_DATE, dbDate);
        //insert a single row of data into the database
        long result = mSqLiteDatabase.insert(TABLE_NAME1, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
        //closing the database
        //mSqLiteDatabase.close();

    }

    /**
     * method for showing the data within the database created
     * @return data
     */

    public Cursor showData(){
        mSqLiteDatabase=this.getWritableDatabase();
        Cursor data = mSqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        return data;
    }

    /**
     * method for updating/ deleting the database values
     * @param id
     * @param weight
     * @param date
     * @return
     */
    public boolean updateData(String id, String weight, String date){
        mSqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_NAME, weight);
        contentValues.put(COL_DATE, date);
        mSqLiteDatabase.update(TABLE_NAME1, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        mSqLiteDatabase=this.getWritableDatabase();
        return mSqLiteDatabase.delete(TABLE_NAME1, "ID = ?", new String[] {id});
    }




}
