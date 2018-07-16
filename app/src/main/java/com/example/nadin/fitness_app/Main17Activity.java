package com.example.nadin.fitness_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Main17Activity extends AppCompatActivity {
    DBHelper dbHelper;
    ArrayList<Measures> measuresArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        /**
         * calling the database helper class
         */
        dbHelper = new DBHelper(this);
        /**
         * calling the insert method from the DBHelper class
         * takes in 2 String values
         * MODIFY: needs to take in editText values
         */
        dbHelper.insertWeight("45", "02/05/2018");
       measuresArrayList = dbHelper.getAllWeight();
    }
}
