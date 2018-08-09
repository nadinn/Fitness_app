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

            }


        });


    }




}
