/**
 * ACTIVITY TO MODIFY THE DATABASE THAT POPULATES THE GRAPH, LINKED TO ACTIVITY 19
 */
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
import android.widget.ImageButton;
import android.widget.Toast;



public class Main17Activity extends AppCompatActivity {
    MyHelper myHelper;


    Button seeValue;
    ImageButton home ;
    Button updateValueX, updateValueY, updateValueZ;
    Button delete;
    EditText xValue, yValue, zValue, idValue;

    /**
     * method created automatically when the class is created
     *
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        /**
         * calling the database helper class
         * */

        myHelper = new MyHelper(this);
        /**
         * creating the edit texts and buttons
         * */


        xValue = (EditText) findViewById(R.id.editText6);
        yValue = (EditText) findViewById(R.id.editText2);
        zValue = (EditText) findViewById(R.id.editTextZ);

        seeValue = (Button) findViewById(R.id.button6);
        updateValueX = (Button) findViewById(R.id.updateX);
        updateValueY = (Button) findViewById(R.id.updateY);
        updateValueZ = (Button) findViewById(R.id.updateZ);

        idValue = (EditText) findViewById(R.id.editText4);
        delete = (Button) findViewById(R.id.button4);

        //addData();
        viewData();
        UpdateDataX();
        UpdateDataY();
        UpdateDataZ();
        DeleteData();


        Button buttonE = (Button) findViewById(R.id.button8);

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main19Activity.class);
                startActivity(start);

            }

        });

        home=(ImageButton)findViewById(R.id.homeButton) ;
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(start);

            }
        });

    }





         /**
         * method for seeing the data inserted within the database
         * */
    public void viewData () {
        seeValue.setOnClickListener(new View.OnClickListener() {
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

                    buffer.append("ID:" + data.getString(0) + "\n");
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

    /**
     * method used to create messages that need to be displayed
     * @param title
     * @param message
     * */
    public void display (String title, String message){
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



    /**
     * method for updating the database
     * */

    public void UpdateDataX () {
        updateValueX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = myHelper.updateDataX(idValue.getText().toString(), Double.parseDouble(xValue.getText().toString()));
                    // message displaly if the data was correctly updated or not
                    if (update == true) {
                        Toast.makeText(Main17Activity.this, "Successfully updated database", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main17Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                    //error message if there is no text entered for the id EditText
                } else {
                    Toast.makeText(Main17Activity.this, "Please enter ID to update", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void UpdateDataY () {
        updateValueY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = myHelper.updateDataY(idValue.getText().toString(), Double.parseDouble(yValue.getText().toString()));
                    // message displaly if the data was correctly updated or not
                    if (update == true) {
                        Toast.makeText(Main17Activity.this, "Successfully updated database", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main17Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                    //error message if there is no text entered for the id EditText
                } else {
                    Toast.makeText(Main17Activity.this, "Please enter ID to update", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void UpdateDataZ () {
        updateValueZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the id is actually entered for the update
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    //updating the database by using the updateData() from DBHelper and passing in the values from the EditTexts
                    boolean update = myHelper.updateDataZ(idValue.getText().toString(), zValue.getText().toString());
                    // message displaly if the data was correctly updated or not
                    if (update == true) {
                        Toast.makeText(Main17Activity.this, "Successfully updated database", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Main17Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                    //error message if there is no text entered for the id EditText
                } else {
                    Toast.makeText(Main17Activity.this, "Please enter ID to update", Toast.LENGTH_LONG).show();
                }
            }
        });
    }





    public void DeleteData() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the length of the input to determine if the user has typed an input
                int temp = idValue.getText().toString().length();
                if (temp > 0) {
                    Integer deleteTuple = myHelper.deleteData(idValue.getText().toString());
                    if (deleteTuple > 0) {
                        Toast.makeText(Main17Activity.this, "Row deleted", Toast.LENGTH_LONG).show(); } else {
                            Toast.makeText(Main17Activity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                    }
                            } else {
                    Toast.makeText(Main17Activity.this, "Please enter ID to delete", Toast.LENGTH_LONG).show(); } }});
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