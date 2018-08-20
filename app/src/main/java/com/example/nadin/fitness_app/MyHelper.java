/**
 * DATABASE HELPER FOR WEIGHT GRAPH - ACTIVITY 17 + 19
 **/
package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MyDatabaseF";
    private static final String IDVALUES = "ID";
    private static final String XVALUES = "xValues";
    private static final String YVALUES = "yValues";
    private static final String ZVALUES = "zValues";
    private static final String TABLE_NAME = "MyTable";
    SQLiteDatabase mySqLiteDatabase;
    private Context con;



    public MyHelper(Context context) {
        super(context, DB_NAME, null, 1);
        con = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " DOUBLE, " + YVALUES + " DOUBLE, " + ZVALUES + " STRING ); ";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(double x, double y, String z) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
        values.put(ZVALUES, z);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor showData(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean updateDataX(String id, double x){
        mySqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDVALUES, id);
        contentValues.put(XVALUES, x);

        mySqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});

        return true;
    }
    public boolean updateDataY(String id, double y){
        mySqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDVALUES, id);
        contentValues.put(YVALUES, y);

        mySqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});

        return true;
    }

    public boolean updateDataZ(String id, String z){
        mySqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDVALUES, id);
        contentValues.put(ZVALUES, z);

        mySqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});

        return true;
    }




    public Integer deleteData(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME, "ID= ?", new String[] {id});
    }

}

/**

 Adapted from: mitchtabian/SQLiteSaveUserData [Internet]. GitHub. 2018 [cited 02 July 2018].
 Available from: https://github.com/mitchtabian/SQLiteSaveUserData https://stackoverflow.com/questions/34939161/how-implement-my-sqlite-data-in-a-graphview

 Save data using SQLite |  Android Developers [Internet]. Android Developers. 2018 [cited 03 July 2018].
 Available from: https://developer.android.com/training/data-storage/sqlite

 Android SQLite Database [Internet]. www.tutorialspoint.com. 2018 [cited 05 July 2018].
 Available from: https://www.tutorialspoint.com/android/android_sqlite_database.htm

 */