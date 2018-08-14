/**
 *
 TESTING DATE STORAGE AND GRAPH POPULATION

package com.example.nadin.fitness_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main52Activity extends AppCompatActivity {
    Button input, viewData, modify;
    EditText inp1, inp2;
    GraphView graph;
    LineGraphSeries<DataPoint> series ;


    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main52);
        viewData =(Button) findViewById(R.id.button11);
        input= (Button) findViewById(R.id.button10);
        inp1 = (EditText) findViewById(R.id.inp1);
        inp2 = (EditText)findViewById(R.id.inp2);
        myHelper = new MyHelper(this);
        sqLiteDatabase = myHelper.getWritableDatabase();
        graph = (GraphView)findViewById(R.id.graph2);
        modify= (Button) findViewById(R.id.button12);

        inputMethod();
        viewData();

        series = new LineGraphSeries<>(getData());

        graph.addSeries(series);
        //graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));



        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main17Activity.class);
                startActivity(start);

            }
        });




    }/**
     * method for adding data to the database from the two EditText



    public void inputMethod() {
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long xVal = new Date().getTime();
                int yVal = Integer.parseInt(String.valueOf(inp2.getText()));
                boolean insertData = myHelper.insertData(xVal, yVal);
                if (insertData == true) {
                    Toast.makeText(Main52Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Main52Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }

                series.resetData(getData());

                graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                    @Override
                    public String formatLabel(double value, boolean isValueX) {
                        if (isValueX) {
                            return simpleDateFormat.format(new Date((long)value));
                        } else {
                            return super.formatLabel(value, isValueX);

                        }
                    }

                });
            }

        });

    }

    /**
     * method used to retrieve data for the graph
     * @return


    private DataPoint[] getData(){
        String[] columns = {"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("MyTable", columns, null, null, null, null, null);
        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getLong(0), cursor.getInt(1));

        }
        return dp;
    }

    /**
     * method for seeing the data inserted within the database

    public void viewData() {
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = myHelper.showData();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0) {
                    display("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {

                    buffer.append("Entry:" + data.getString(0) + "\n");
                    buffer.append("Date: " + data.getString(1) + "\n");
                    buffer.append("Weight: " + Integer.parseInt(data.getString(2)) + "\n");



                }
                // displaying the message when the data can be retrieved correctly
                display("All data", buffer.toString());




            }
        });
    }

    public void display(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();

    }


}
 */



