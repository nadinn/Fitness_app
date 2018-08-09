package com.example.nadin.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelperStats extends SQLiteOpenHelper {

    private static final String DB_NAME = "DatabaseStats";
    private static final String IDVALUES = "ID";
    private static final String ABSVALUES = "absValues";
    private static final String CHESTVALUES = "chestValues";
    private static final String BACKVALUES = "backValues";
    private static final String BICEPSVALUES = "bicepsValues";
    private static final String GLUTESVALUES = "glutesValues";
    private static final String QUADSVALUES = "quadsValues";
    private static final String TRICEPSVALUES = "tricepsValues";
    private static final String TABLE_NAME = "MyTable";

    SQLiteDatabase mySqLiteDatabase;
    private Context con;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + IDVALUES + " INTEGER PRIMARY KEY, " + ABSVALUES + " INTEGER DEFAULT (0)  NOT NULL , " + BACKVALUES + " INTEGER DEFAULT (0) NOT NULL , " + BICEPSVALUES + " INTEGER DEFAULT (0) NOT NULL , " +
            CHESTVALUES + " INTEGER DEFAULT (0) NOT NULL , " + GLUTESVALUES + " INTEGER DEFAULT (0) NOT NULL , " + QUADSVALUES + " INTEGER DEFAULT (0) NOT NULL , " + TRICEPSVALUES + " INTEGER DEFAULT (0) NOT NULL ); ";

    public MyHelperStats(Context context) {
        super(context, DB_NAME, null, 1);
        con = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData() {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
        values.put(ABSVALUES,0);
        values.put(BACKVALUES,0);
        values.put(BICEPSVALUES,0);
        values.put(CHESTVALUES,0);
        values.put(GLUTESVALUES,0);
        values.put(QUADSVALUES,0);
        values.put(TRICEPSVALUES,0);
    long result = db.insert(TABLE_NAME, null, values);
        if(result ==-1)

    {
        return false;
    } else

    {
        return true;
    }

}




    public void updateAbs(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

    db.execSQL("UPDATE " + TABLE_NAME  + " SET " + ABSVALUES + "=" + ABSVALUES + "+1" + " WHERE " + IDVALUES + "=?",
            new String[] { String.valueOf(id) } );

    }


    public Cursor showData(){
        mySqLiteDatabase=this.getWritableDatabase();
        Cursor data = mySqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }


}
