package com.example.nadin.fitness_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Main17Activity extends AppCompatActivity {
    MyHelper myHelper;

    Button addValue;
    Button seeValue;
    Button updateValue;
    Button delete;
    EditText xValue, yValue, idValue;

    /**
     * method created automatically when the class is created
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        /**
         * calling the database helper class
         */
        myHelper = new MyHelper(this);
        /**
         * creating the edit texts and buttons
         */

        xValue= (EditText) findViewById(R.id.editText6);
        yValue=(EditText) findViewById(R.id.editText2);
        addValue = (Button) findViewById(R.id.button5);
        seeValue = (Button) findViewById(R.id.button6);
        updateValue= (Button) findViewById(R.id.button7);
        idValue = (EditText) findViewById(R.id.editText4);
        delete = (Button) findViewById(R.id.button4);

        //addData();
        viewData();
        UpdateData();
        DeleteData();

        Button buttonE = (Button) findViewById(R.id.button8);
        buttonE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main19Activity.class);
                startActivity(start);

            }

        });



    }

    /**
     * method for adding data to the database from the two EditText


    public void addData(){
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = String.valueOf(edate.getText());
                String weight =String.valueOf(eweight.getText());
                //long date = new Date().getTime();

                //calling the method insertWeight from DBHelper to insert data into the database
                boolean insertData = myHelper.insertData(date, weight);

                //message displayed if data has been added correctly
                if (insertData == true){
                    Toast.makeText(Main17Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main17Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }


            }
        });

    }
     */

    /**
     * method for seeing the data inserted within the database
     */
    public void viewData(){
        seeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = myHelper.showData();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0){
                    display("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {

                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Date: " + Integer.parseInt(data.getString(1)) + "\n");
                    buffer.append("Weight: " + Integer.parseInt(data.getString(2)) + "\n");



                }
                // displaying the message when the data can be retrieved correctly
                display("All data",  buffer.toString());





            }
        });

    }

    /**
     * method used to create messages that need to be displayed
     * @param title
     * @param message
     */
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

        //builder.show();



    }


    /**
     * method for updating the database
     */
    public void UpdateData (){
        updateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = idValue.getText().toString().length();
                if (temp > 0 ){
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = myHelper.updateData(idValue.getText().toString(),Integer.parseInt(xValue.getText().toString()),
                            Integer.parseInt(yValue.getText().toString()));
                    // message displaly if the data was correctly updated or not
                    if (update == true){
                        Toast.makeText(Main17Activity.this, "Successfully updated database", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Main17Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                //error message if there is no text entered for the id EditText
                }else{
                    Toast.makeText(Main17Activity.this, "Please enter ID to update", Toast.LENGTH_LONG).show();

                }

            }
        });

    }


    public void DeleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //checking the length of the input to determine if the user has typed an input
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    Integer deleteTuple = myHelper.deleteData(idValue.getText().toString());
                    if (deleteTuple > 0) {
                        Toast.makeText(Main17Activity.this, "Row deleted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main17Activity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Main17Activity.this, "Please enter ID to delete", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

/**
 source: https://github.com/mitchtabian/SQLiteSaveUserData
 */
