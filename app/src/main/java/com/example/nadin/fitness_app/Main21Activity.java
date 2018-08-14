/**
 * ABS EXERCISE 1 - DATABASE POPULATION + GRAPH
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
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main21Activity extends AppCompatActivity {
    Button input, viewData, updateValue, delete;
    EditText inp1, inp2,idValue;
    GraphView graph;
    LineGraphSeries<DataPoint> series;
    //LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);

    MyHelperAbs myHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        viewData =(Button) findViewById(R.id.absView1);
        input= (Button) findViewById(R.id.absButton1);
        updateValue = (Button) findViewById(R.id.absUpdate);
        delete = (Button) findViewById(R.id.absDelete);
        inp1 = (EditText) findViewById(R.id.absInput1);
        inp2 = (EditText)findViewById(R.id.absInput2);
        idValue = (EditText) findViewById(R.id.id1);
        myHelper = new MyHelperAbs(this);
        sqLiteDatabase = myHelper.getWritableDatabase();
        graph = (GraphView)findViewById(R.id.graph3);


        inputMethod();
        viewData();
        updateData();
        deleteData();



        series = new LineGraphSeries<>(getData());

        graph.addSeries(series);




    }/**
     * method for adding data to the database from the two EditText
     */


    public void inputMethod() {
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int xVal = Integer.parseInt(String.valueOf(inp1.getText()));
                int yVal = Integer.parseInt(String.valueOf(inp2.getText()));
                boolean insertData = myHelper.insertData1(xVal, yVal);
                if (insertData == true){
                    Toast.makeText(Main21Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main21Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }
                //series= new LineGraphSeries<DataPoint>(getData());
                series.resetData(getData());
                //graph.addSeries(series);
            }

        });

    }

    /**
     * method used to retrieve data for the graph
     * @return
     */

    private DataPoint[] getData(){
        String[] columns = {"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("MyTable1", columns, null, null, null, null, "xValues");
        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getInt(0), cursor.getInt(1));

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
                Cursor data = myHelper.showData1();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0) {
                    display("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {

                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Entry number: " + Integer.parseInt(data.getString(1)) + "\n");
                    buffer.append("Repetitions number : " + Integer.parseInt(data.getString(2)) + "\n");



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

    public void updateData (){
        updateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = idValue.getText().toString().length();
                if (temp > 0 ){
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = myHelper.updateData1(idValue.getText().toString(),Integer.parseInt(inp1.getText().toString()),
                            Integer.parseInt(inp2.getText().toString()));
                    // message displaly if the data was correctly updated or not
                    if (update == true){
                        Toast.makeText(Main21Activity.this, "Successfully updated database", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Main21Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                    //error message if there is no text entered for the id EditText
                }else{
                    Toast.makeText(Main21Activity.this, "Please enter ID to update", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    public void deleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the length of the input to determine if the user has typed an input
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    Integer deleteTuple = myHelper.deleteData1(idValue.getText().toString());
                    if (deleteTuple > 0) {
                        Toast.makeText(Main21Activity.this, "Row deleted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main21Activity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Main21Activity.this, "Please enter ID to delete", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}