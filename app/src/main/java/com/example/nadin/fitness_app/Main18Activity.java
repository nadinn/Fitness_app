package com.example.nadin.fitness_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main18Activity extends AppCompatActivity {

    DBHelper myHelper;
    SQLiteDatabase sqlDataBase;
    GraphView graph;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);


        myHelper = new DBHelper(this);
        sqlDataBase =  myHelper.getWritableDatabase();
        graph = (GraphView)findViewById(R.id.graph2);


        series = new LineGraphSeries<DataPoint>(getData());



    }



    private DataPoint[] getData(){
        //reading the data from the database
        String[] columns = {"COL_NAME","COL_DATE"};
        Cursor cursor = sqlDataBase.query("TABLE_NAME", columns, null,null, null, null, null);

        DataPoint [] dp = new DataPoint[cursor.getCount()];

        // running till the number of rows in the db is done

        for(int i =0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]=new DataPoint(cursor.getInt(0), cursor.getInt(1));
        }
        return dp;

    }
}
