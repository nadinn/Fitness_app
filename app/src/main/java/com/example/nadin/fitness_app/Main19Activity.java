/**
 * ACTIVITY THAT TAKES IN DATA(ENTRY, WEIGHT, DATE ) INPUTS AND DISPLAYS THEM ON THE GRAPH
 */

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
import android.widget.ImageButton;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;

public class Main19Activity extends AppCompatActivity {

    Button input, viewData, modify;
    ImageButton home;
    EditText inp1, inp2, inp3;
    GraphView graph;
    LineGraphSeries<DataPoint> series;

    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        viewData =(Button) findViewById(R.id.button11);
        input= (Button) findViewById(R.id.button10);
        inp1 = (EditText) findViewById(R.id.inp1);
        inp2 = (EditText)findViewById(R.id.inp2);
        inp3 = (EditText)findViewById(R.id.inp3);
        myHelper = new MyHelper(this);
        sqLiteDatabase = myHelper.getWritableDatabase();
        graph = (GraphView)findViewById(R.id.graph2);
        modify= (Button) findViewById(R.id.button12);

        home=(ImageButton)findViewById(R.id.homeButton) ;
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(start);

            }
        });

        
        inputMethod();
        viewData();

        series = new LineGraphSeries<>(getData());
        graph.addSeries(series);

        //StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        //staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new"});
       // staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
        //graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);



        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main17Activity.class);
                startActivity(start);

            }
        });

    }
    /**
     * method for adding data to the database from the two EditText
      */



     public void inputMethod() {
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double xVal =Double.parseDouble(String.valueOf(inp1.getText()));
                double yVal = Double.parseDouble(String.valueOf(inp2.getText()));
                String zVal= String.valueOf(inp3.getText());
               boolean insertData = myHelper.insertData(xVal, yVal, zVal);
                if (insertData == true){
                    Toast.makeText(Main19Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main19Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }

                series.resetData(getData());

            }

        });

    }

    /**
     * method used to retrieve data for the graph
     * @return
     * */


    private DataPoint[] getData(){
        String[] columns = {"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("MyTable", columns, null, null, null, null, "xValues");
        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getInt(0), cursor.getInt(1));

        }
        return dp;
    }


    /**
     * method for seeing the data inserted within the database
     * */

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
                    buffer.append("Entry #: " + Double.parseDouble(data.getString(1)) + "\n");
                    buffer.append("Date: " + data.getString(3) + "\n");
                    buffer.append("Weight: " + Double.parseDouble(data.getString(2)) + "\n");
                    buffer.append("\n");
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
/**

 Adapted from: mitchtabian/SQLiteSaveUserData [Internet]. GitHub. 2018 [cited 02 July 2018].
 Available from: https://github.com/mitchtabian/SQLiteSaveUserData https://stackoverflow.com/questions/34939161/how-implement-my-sqlite-data-in-a-graphview

 Save data using SQLite |  Android Developers [Internet]. Android Developers. 2018 [cited 03 July 2018].
 Available from: https://developer.android.com/training/data-storage/sqlite

 Android SQLite Database [Internet]. www.tutorialspoint.com. 2018 [cited 05 July 2018].
 Available from: https://www.tutorialspoint.com/android/android_sqlite_database.htm

*/
