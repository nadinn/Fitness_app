/**
 * TRICEPS EXERCISE 3 - DATABASE POPULATION + GRAPH
 */


package com.example.nadin.fitness_app;


import android.content.DialogInterface;
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

public class Main47Activity extends AppCompatActivity {

    Button input, viewData, delete;
    EditText inp1, inp2,idValue;
    GraphView graph;
    LineGraphSeries<DataPoint> series;

    MyHelperTriceps myHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main47);

        viewData =(Button) findViewById(R.id.absView1);
        input= (Button) findViewById(R.id.absButton1);
        delete = (Button) findViewById(R.id.absDelete);
        inp1 = (EditText) findViewById(R.id.absInput1);
        inp2 = (EditText)findViewById(R.id.absInput2);
        idValue = (EditText) findViewById(R.id.id1);
        myHelper = new MyHelperTriceps(this);
        sqLiteDatabase = myHelper.getWritableDatabase();
        graph = (GraphView)findViewById(R.id.graph3);


        inputMethod();
        viewData();
        deleteData();



        series = new LineGraphSeries<>(getData());

        graph.addSeries(series);


    }
    /**
     * method for adding data to the database from the two EditText
     */


    public void inputMethod() {
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double xVal = Double.parseDouble(String.valueOf(inp1.getText()));
                double yVal = Double.parseDouble(String.valueOf(inp2.getText()));
                boolean insertData = myHelper.insertData3(xVal, yVal);
                if (insertData == true){
                    Toast.makeText(Main47Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main47Activity.this, "Data not added ", Toast.LENGTH_LONG).show();
                }
                series.resetData(getData());
            }

        });

    }

    /**
     * method used to retrieve data for the graph
     * @return
     */

    private DataPoint[] getData(){
        String[] columns = {"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("MyTable3", columns, null, null, null, null, "xValues");
        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getDouble(0), cursor.getDouble(1));

        }
        return dp;
    }

    /**
     * method for seeing the data inserted within the database
     */
    public void viewData() {
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = myHelper.showData3();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0) {
                    display("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {

                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Entry number: " + Double.parseDouble(data.getString(1)) + "\n");
                    buffer.append("Repetitions number : " + Double.parseDouble(data.getString(2)) + "\n");
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

    public void deleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the length of the input to determine if the user has typed an input
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    Integer deleteTuple = myHelper.deleteData3(idValue.getText().toString());
                    if (deleteTuple > 0) {
                        Toast.makeText(Main47Activity.this, "Row deleted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main47Activity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Main47Activity.this, "Please enter ID to delete", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
/**

 Adapted from:
 mitchtabian/SQLiteSaveUserData [Internet]. GitHub. 2018 [cited 02 July 2018].
 Available from: https://github.com/mitchtabian/SQLiteSaveUserData https://stackoverflow.com/questions/34939161/how-implement-my-sqlite-data-in-a-graphview

 Save data using SQLite |  Android Developers [Internet]. Android Developers. 2018 [cited 03 July 2018].
 Available from: https://developer.android.com/training/data-storage/sqlite

 Android SQLite Database [Internet]. www.tutorialspoint.com. 2018 [cited 05 July 2018].
 Available from: https://www.tutorialspoint.com/android/android_sqlite_database.htm

 Simple graph [Internet]. Android-graphview.org. 2018 [cited 08 July 2018].
 Available from: http://www.android-graphview.org/simple-graph/

 jjoe64/GraphView [Internet]. GitHub. 2018 [cited 13 July 2018].
 Available from: https://github.com/jjoe64/GraphView

 AlertDialog.Builder  |  Android Developers [Internet]. Android Developers. 2018   [cited 28 July 2018].
 Available from:   https://developer.android.com/reference/android/app/AlertDialog.Builder

 Android Alert Dialog with one a. Android Alert Dialog with one, two, and three buttons [Internet]. Stack Overflow. 2018 [cited 28 July 2018].
 Available from: https://stackoverflow.com/questions/43513919/android-alert-dialog-with-one-two-and-three-buttons

 */