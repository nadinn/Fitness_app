package com.example.nadin.fitness_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main18Activity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;
    GraphView graph;
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);
    Button seeDataButton;
    Button updateGraph, addValue;
    EditText eweight, edate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);

        edate= (EditText) findViewById(R.id.editText7);
        eweight=(EditText) findViewById(R.id.editText8);

        addValue = (Button) findViewById(R.id.button11);


        seeDataButton = (Button) findViewById(R.id.button9);

        dbHelper = new DBHelper(this);
        db=dbHelper.getWritableDatabase();

        viewData1();
        addData();



        graph = (GraphView)findViewById(R.id.graph2);

        //series = new LineGraphSeries<DataPoint>(getData());



        //LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

                /**
                 * static datapoins for testing
                */
                //new DataPoint(0, 1),
                //new DataPoint(1, 2),
               // new DataPoint(2, 1.5)
       // });

        graph.addSeries(series);






    }


    public void addData(){
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long date = Long.parseLong(String.valueOf(edate.getText()));
                long weight = Long.parseLong(String.valueOf(eweight.getText()));
                //long date = new Date().getTime();

                //calling the method insertWeight from DBHelper to insert data into the database
                boolean insertData = dbHelper.insertData(date, weight);

                //message displayed if data has been added correctly
                if (insertData == true){
                    Toast.makeText(Main18Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main18Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }
                series.resetData(getData());

            }
        });

    }



    private DataPoint[] getData(){
        //reading the data from the database
        String[] columns = {"COL_DATE","COL_NAME"};
        Cursor cursor = db.query("TABLE_NAME", columns, null,null, null, null, null);

        DataPoint [] dp = new DataPoint[cursor.getCount()];

        // running till the number of rows in the db is done

        for(int i =0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]=new DataPoint(cursor.getLong(1), cursor.getLong(2));
        }
        return dp;

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

    public void display(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




}
