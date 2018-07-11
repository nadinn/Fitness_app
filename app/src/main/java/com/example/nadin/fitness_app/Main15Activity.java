/** NOT IN USE
 *

package com.example.nadin.fitness_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;
import java.util.Date;

public class Main15Activity extends AppCompatActivity {

    public static ArrayList<String> dateAxis=new ArrayList<String>();
    public static ArrayList<String> weightAxis=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);


        Button btnAdd = (Button) findViewById(R.id.button);
        final EditText weight = (EditText) findViewById(R.id.editText3);
        final EditText weight1 = (EditText) findViewById(R.id.editText5);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightAxis.add(weight.getText().toString());
                dateAxis.add(weight1.getText().toString());
            }
        });


        GraphView graph;
        PointsGraphSeries<DataPoint> series;       //an Object of the PointsGraphSeries for plotting scatter graphs
        graph = (GraphView) findViewById(R.id.graph1);
        series = new PointsGraphSeries<>(data());   //initializing/defining series to get the data from the method 'data()'
        graph.addSeries(series);                   //adding the series to the GraphView
        series.setShape(PointsGraphSeries.Shape.POINT);
        series.setSize(5);


    }

    public DataPoint[] data(){
        int n=dateAxis.size();     //to find out the no. of data-points
        DataPoint[] values = new DataPoint[n];     //creating an object of type DataPoint[] of size 'n'
        for(int i=0;i<n;i++){
            DataPoint v = new DataPoint(Double.parseDouble(dateAxis.get(i)), Double.parseDouble(weightAxis.get(i)));
            values[i] = v;
        }
        return values;
    }

}
 /**
  * http://www.bragitoff.com/2017/04/add-data-graphview-arrays-solved-android-studio/

  */