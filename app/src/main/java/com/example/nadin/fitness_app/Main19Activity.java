package com.example.nadin.fitness_app;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main19Activity extends AppCompatActivity {
    Button button;
    EditText Xinput, Yinput;
    GraphView graph;
    LineGraphSeries<DataPoint> series;
    DBHelper1 helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
       helper = new DBHelper1(this);

       button = (Button)findViewById(R.id.button12);
       Xinput =(EditText)findViewById(R.id.ed)

    }
}
