package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelperQuads extends SQLiteOpenHelper {
    private static final String DB_NAME = "DatabaseQuads";
    private static final String IDVALUES = "ID";
    private static final String XVALUES = "xValues";
    private static final String YVALUES = "yValues";
    private static final String TABLE_NAME1 = "MyTable1";
    private static final String TABLE_NAME2 = "MyTable2";
    private static final String TABLE_NAME3 = "MyTable3";
    private static final String TABLE_NAME4 = "MyTable4";

    SQLiteDatabase mySqLiteDatabase;
    private Context con;

    private static final String CREATE_TABLE_1 =  "CREATE TABLE " + TABLE_NAME1 + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " INTEGER, " + YVALUES + " INTEGER ); ";
    private static final String CREATE_TABLE_2 =  "CREATE TABLE " + TABLE_NAME2 + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " INTEGER, " + YVALUES + " INTEGER ); ";
    private static final String CREATE_TABLE_3 =  "CREATE TABLE " + TABLE_NAME3 + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " INTEGER, " + YVALUES + " INTEGER ); ";
    private static final String CREATE_TABLE_4 =  "CREATE TABLE " + TABLE_NAME4 + "(" + IDVALUES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + XVALUES + " INTEGER, " + YVALUES + " INTEGER ); ";



    public MyHelperQuads(Context context) {
        super(context, DB_NAME, null, 1);
        con = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        db.execSQL(CREATE_TABLE_4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);

        onCreate(db);

    }

    public boolean insertData1(int x, int y) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
        long result = db.insert(TABLE_NAME1, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertData2(int x, int y) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
        long result = db.insert(TABLE_NAME2, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertData3(int x, int y) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
        long result = db.insert(TABLE_NAME3, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertData4(int x, int y) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(XVALUES, x);
        values.put(YVALUES, y);
        long result = db.insert(TABLE_NAME4, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor showData1(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        return data;
    }
    public Cursor showData2(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
        return data;
    }

    public Cursor showData3(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME3, null);
        return data;
    }

    public Cursor showData4(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME4, null);
        return data;
    }

    public boolean updateData1(String id, int x, int y){
        mySqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDVALUES, id);
        contentValues.put(XVALUES, x);
        contentValues.put(YVALUES, y);

        mySqLiteDatabase.update(TABLE_NAME1, contentValues, "ID = ?", new String[] {id});

        return true;
    }

    public Integer deleteData1(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME1, "ID= ?", new String[] {id});
    }

    public Integer deleteData2(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME2, "ID= ?", new String[] {id});
    }

    public Integer deleteData3(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME3, "ID= ?", new String[] {id});
    }

    public Integer deleteData4(String id){
        mySqLiteDatabase=this.getWritableDatabase();
        return mySqLiteDatabase.delete(TABLE_NAME4, "ID= ?", new String[] {id});
    }

}