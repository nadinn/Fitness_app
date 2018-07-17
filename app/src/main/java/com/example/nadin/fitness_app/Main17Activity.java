package com.example.nadin.fitness_app;

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
    EditText eweight, edate;

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

        addData();


        /**
         * calling the insert method from the DBHelper class
         * takes in 2 String values
         * MODIFY: needs to take in editText values
         */
        dbHelper.insertWeight("45", "02/05/2018");
       measuresArrayList = dbHelper.getAllWeight();
    }
    public void addData(){
        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String weight = eweight.getText().toString();
                String date = edate.getText().toString();
                //calling the method from DBHelper to
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
}
