package com.example.nadin.fitness_app;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.series.DataPoint;

public class Main49Activity extends AppCompatActivity {
    Button viewData, update;
    MyHelperStats myHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main49);

        viewData =(Button) findViewById(R.id.button5);
        update = (Button) findViewById(R.id.button13);
        myHelper = new MyHelperStats(this);
        sqLiteDatabase = myHelper.getWritableDatabase();

        viewData();
        inputData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = Integer.toString(1);
                 myHelper.updateAbs(i);
            }
        });


    }

    public void viewData() {
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = myHelper.showData();
                 //displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0) {
                    display("Error", "No data has been found");
                    return;
                }
                 //buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {

                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Abs: " + Integer.parseInt(data.getString(1)) + "\n");
                    //buffer.append("Back : " + Integer.parseInt(data.getString(2)) + "\n");
                    //buffer.append("Biceps : " + Integer.parseInt(data.getString(3)) + "\n");
                    //buffer.append("Chest : " + Integer.parseInt(data.getString(4)) + "\n");
                    //buffer.append("Glutes : " + Integer.parseInt(data.getString(5)) + "\n");
                    //buffer.append("Quads: " + Integer.parseInt(data.getString(6)) + "\n");
                    //buffer.append("Triceps : " + Integer.parseInt(data.getString(7)) + "\n");



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

    public void inputData(){
        myHelper.insertData();
    }



}
