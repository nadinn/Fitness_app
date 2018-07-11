package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Main2Activity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadWeight();
        /**
         * creating button that saves whatever is written in the edit text
         */
        final Button saveWeight = (Button) findViewById(R.id.saveWeight);
        final EditText editText = (EditText) findViewById(R.id.editWeight1);
        if (saveWeight != null) {
            saveWeight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                   saveWeight("editWeight1",editText.getText().toString());
                }
            });



            /**
             * creating new GraphView objects and finding it by id
             */
            GraphView graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

                    /**
                     * static datapoins for testing
                    */
                    new DataPoint(0, 1),
                    new DataPoint(1, 2),
                    new DataPoint(2, 1.5)
            });

            /**
             * adding series to the graph
             */
            graph.addSeries(series);


        }


    }

    /**
     * method that uses shared preferences to load the inputs from the user onto the edit text
     */
    private void loadWeight() {
        EditText inputWeight = (EditText) findViewById(R.id.editWeight1);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String value = sp.getString("editWeight1", null);
        inputWeight.setText(value);;
    }


    private void saveWeight(String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }

}


/**
 source https://stackoverflow.com/questions/38339982/save-number-input-from-edittext-into-sharedpreferences/38340272
 */