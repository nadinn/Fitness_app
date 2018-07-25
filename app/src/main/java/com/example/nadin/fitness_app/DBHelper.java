package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DatabaseOne.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Input_Table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME ";
    private static final String COL_DATE = "DATE";
    SQLiteDatabase mSqLiteDatabase;

    public DBHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " LONG, " + COL_DATE + " LONG ); ";

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    public boolean insertData(long dbDate,long dbWeight ) {
        mSqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DATE, dbDate);
        values.put(COL_NAME, dbWeight);

        //insert a single row of data into the database
        long result = mSqLiteDatabase.insert(TABLE_NAME, null, values);
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
        Cursor data = mSqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    /**
     * method for updating/ deleting the database values
     * @param id
     * @param weight
     * @param date
     * @return
     */
    public boolean updateData(String id, long date, long weight){
        mSqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_DATE, date);
        contentValues.put(COL_NAME, weight);

        mSqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        mSqLiteDatabase=this.getWritableDatabase();
        return mSqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }




}
