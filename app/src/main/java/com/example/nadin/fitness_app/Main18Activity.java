package com.example.nadin.fitness_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Main18Activity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;

    Button seeDataButton;
    //ArrayList<String> xx = new ArrayList<>(getXAxis());
    //ArrayList<String> yy = new ArrayList<>(getYAxis());




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        //getXAxis();



        //GraphView graph =(GraphView)findViewById(R.id.graph2);
        //LineGraphSeries<DataPoint> series;
        //series = new LineGraphSeries<>(data());
        //graph.addSeries(series);


        seeDataButton = (Button) findViewById(R.id.button9);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        viewData1();
        //addData();


        /** static datapoins for testing
         */

        //series = new LineGraphSeries<DataPoint>(getData());
        //LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

        //new DataPoint(0, 1),
        //new DataPoint(1, 2),
        // new DataPoint(2, 1.5)
        // });
    }

    public void viewData1() {
        seeDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = dbHelper.showData();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0) {
                    display("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {
                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Date: " + data.getString(1) + "\n");
                    buffer.append("Weight: " + data.getString(2) + "\n");

                    // displaying a message when the data can be retrieved correctly

                    display("All data", buffer.toString());


                }




            }
        });

    }

    public ArrayList<String> getXAxis(){
        ArrayList<String> dataX=new ArrayList<String>();
        Cursor cursor = db.query("TABLE_NAME", new String[]{"COL_DATE"},null, null, null, null, null);
        String fieldToAdd=null;
        while(cursor.moveToNext()){
            fieldToAdd=cursor.getString(1);
            dataX.add(fieldToAdd);
        }
        cursor.close();
        TextView mText = (TextView) findViewById(R.id.textView5);
        for (int i = 0; i < dataX.size(); i++) {
            mText.setText(dataX.get(i));
        }
        return dataX;


    }

    public ArrayList<String> getYAxis(){
        ArrayList<String> dataY=new ArrayList<String>();
        Cursor cursor = db.query("TABLE_NAME", new String[]{"COL_NAME"},null, null, null, null, null);
        String fieldToAdd=null;
        while(cursor.moveToNext()){
            fieldToAdd=cursor.getString(2);
            dataY.add(fieldToAdd);
        }
        cursor.close();
        return dataY;
    }

    //public DataPoint[] data(){
       // int n=xx.size();     //to find out the no. of data-points
        //DataPoint[] values = new DataPoint[n];     //creating an object of type DataPoint[] of size 'n'
        //for(int i=0;i<n;i++){
          //  DataPoint v = new DataPoint(Double.parseDouble(xx.get(i)),Double.parseDouble(yy.get(i)));
         //   values[i] = v;
       // }
       // return values;
   // }

    public void display(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    /**
     public void addData(){
     addValue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    /** double date = Double.parseDouble(String.valueOf(edate.getText()));
    double weight = Double.parseDouble(String.valueOf(eweight.getText()));
    //long date = new Date().getTime();

    //calling the method insertWeight from DBHelper to insert data into the database
    boolean insertData = dbHelper.insertData(date, weight);

    //message displayed if data has been added correctly
    if (insertData == true){
    Toast.makeText(Main18Activity.this, "Data added ", Toast.LENGTH_LONG).show();
    } else{
    Toast.makeText(Main18Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

    }



    }
    });

     }

     */
/**
 private DataPoint[] getDataPoint(){
 //reading the data from the database
 String[] columns = {"COL_DATE","COL_NAME"};
 Cursor cursor = db.query("TABLE_NAME", columns, null,null, null, null, null);

 DataPoint [] dp = new DataPoint[cursor.getCount()];

 // running till the number of rows in the db is done

 for(int i =0; i<cursor.getCount(); i++){
 cursor.moveToNext();
 dp[i]=new DataPoint(cursor.getInt(1), cursor.getInt(0));
 }
 return dp;

 }
 */



}
