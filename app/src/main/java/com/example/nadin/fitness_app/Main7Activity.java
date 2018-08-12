package com.example.nadin.fitness_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();


        /**
        * creating buttonAbs and finding it by id from xml
        */
        ImageButton buttonAbs = (ImageButton) findViewById(R.id.imageButton);

        /**
         * setting an onClick listener to the button for new Activity
         */

        buttonAbs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main8Activity.class);
                startActivity(start);

                int counterAbs = preferences.getInt("counterAbs", 0);
                counterAbs = counterAbs + 1;
                edit.putInt("counterAbs", counterAbs).commit();


                }


        });


        /**
         * creating buttonBack and finding it by id from xml
         */
        ImageButton buttonBack = (ImageButton) findViewById(R.id.imageButton2);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main9Activity.class);
                startActivity(start);

                int counterBack = preferences.getInt("counterBack", 0);
                counterBack = counterBack + 1;
                edit.putInt("counterBack", counterBack).commit();

            }


        });


/**
 * creating buttonBiceps and finding it by id from xml
 */
        ImageButton buttonBiceps = (ImageButton) findViewById(R.id.imageButton3);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonBiceps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main10Activity.class);
                startActivity(start);

                int counterBi = preferences.getInt("counterBi", 0);
                counterBi = counterBi + 1;
                edit.putInt("counterBi", counterBi).commit();

            }


        });


        /**
         * creating buttonChest and finding it by id from xml
         */
        ImageButton buttonChest = (ImageButton) findViewById(R.id.imageButton4);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonChest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main11Activity.class);
                startActivity(start);

                int counterChest = preferences.getInt("counterChest", 0);
                counterChest = counterChest + 1;
                edit.putInt("counterChest", counterChest).commit();

            }


        });

        /**
         * creating buttonGlutes and finding it by id from xml
         */
        ImageButton buttonGlutes = (ImageButton) findViewById(R.id.imageButton5);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonGlutes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main12Activity.class);
                startActivity(start);

                int counterGlutes = preferences.getInt("counterGlutes", 0);
                counterGlutes = counterGlutes + 1;
                edit.putInt("counterGlutes", counterGlutes).commit();

            }


        });


        /**
         * creating buttonQuads and finding it by id from xml
         */
        ImageButton buttonQuads = (ImageButton) findViewById(R.id.imageButton6);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonQuads.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main13Activity.class);
                startActivity(start);

                int counterQuads = preferences.getInt("counterQuads", 0);
                counterQuads = counterQuads + 1;
                edit.putInt("counterQuads", counterQuads).commit();

            }


        });

        /**
         * creating buttonTriceps and finding it by id from xml
         */
        ImageButton buttonTriceps = (ImageButton) findViewById(R.id.imageButton7);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonTriceps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main14Activity.class);
                startActivity(start);

                int counterTri = preferences.getInt("counterTri", 0);
                counterTri = counterTri + 1;
                edit.putInt("counterTri", counterTri).commit();

            }


        });


    }




}
