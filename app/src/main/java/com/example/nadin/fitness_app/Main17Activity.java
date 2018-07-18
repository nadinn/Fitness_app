package com.example.nadin.fitness_app;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Main17Activity extends AppCompatActivity {
    DBHelper dbHelper;
    ArrayList<Measures> measuresArrayList;
    Button addValue;
    Button seeValue;
    Button updateValue;
    EditText eweight, edate, eId;

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
        dbHelper = new DBHelper(this);
        /**
         * creating the edit text and button
         */
        eweight=(EditText) findViewById(R.id.editText2);
        edate= (EditText) findViewById(R.id.editText6);
        addValue = (Button) findViewById(R.id.button5);
        seeValue = (Button) findViewById(R.id.button6);
        updateValue= (Button) findViewById(R.id.button7);
        eId = (EditText) findViewById(R.id.editText4);

        addData();
        viewData();
        UpdateData();



        /**
         * calling the insert method from the DBHelper class

         */
        //dbHelper.insertWeight("45", "02/05/2018");
       //measuresArrayList = dbHelper.getAllWeight();
    }

    /**
     * method for adding data to the database from the two EditText
     */

    public void addData(){
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String weight = eweight.getText().toString();
                String date = edate.getText().toString();
                //calling the method insertWeight from DBHelper to insert data into the database
                boolean insertData = dbHelper.insertWeight(weight,date);

                //message displayed if data has been added correctly
                if (insertData == true){
                    Toast.makeText(Main17Activity.this, "Data added ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Main17Activity.this, "Data not added ", Toast.LENGTH_LONG).show();

                }


            }
        });

    }

    /**
     * method for seeing the data inserted within the database
     */
    public void viewData(){
        seeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = dbHelper.showData();
                // displaying an error message if no data is present using the display() method created
                if (data.getCount() == 0){
                    dispay("Error", "No data has been found");
                    return;
                }
                // buffer used to view contents in the database
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()){
                    buffer.append("ID:" + data.getString(0) + "\n");
                    buffer.append("Weight: " + data.getString(1) + "\n");
                    buffer.append("Date: " + data.getString(2) + "\n");

                    // displaying a message when the data can be retrieved correctly

                    dispay("All data",  buffer.toString());



                }

            }
        });

    }

    /**
     * method used to create messages that need to be displayed
     * @param title
     * @param message
     */
    public void dispay(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    /**
     * method for updating the database
     */
    public void UpdateData (){
        updateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = eId.getText().toString().length();
                if (temp > 0 ){
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = dbHelper.updateData(eId.getText().toString(),
                            eweight.getText().toString(),edate.getText().toString());
                    // message dispaly if the data was correctly updated or not
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

}
