package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MyDatabase1";
    private static final String IDVALUES = "ID";
    private static final String XVALUES = "xValues";
    private static final String YVALUES = "yValues";
    private static final String TABLE_NAME = "MyTable";
    SQLiteDatabase mySqLiteDatabase;
    private Context con;


    public MyHelper(Context context) {
        super(context, DB_NAME, null, 1);
        con = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTable = "create table TABLE_NAME (idValues INTEGER PRIMARY KEY AUTOINCREMENT, xValues INTEGER, yValues INTEGER);";
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " INTEGER, " + YVALUES + " INTEGER ); ";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(int x, int y) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
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

    public boolean updateData(String id, int x, int y){
        mySqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDVALUES, id);
        contentValues.put(XVALUES, x);
        contentValues.put(YVALUES, y);

        mySqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});

        return true;
    }

    public Integer deleteData(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME, "ID= ?", new String[] {id});
    }

}

