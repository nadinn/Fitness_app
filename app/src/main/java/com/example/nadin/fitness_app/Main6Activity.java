/**  TEST ACTIVITY - NOT IN USE
 *

package com.example.nadin.fitness_app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

public class Main6Activity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imgPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
/**
 * initialise the spinner and imageView

        this.spinner = (Spinner) findViewById(R.id.spinner1);
        this.imgPlace = (ImageView) findViewById(R.id.imgPlace);
/**
 * initialise database access

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        /**
         * *  opening the database

        databaseAccess.open();

        /**
         * reading the exercise names

        final List<String> names = databaseAccess.getExercise();

        /**
         * closing the database


        databaseAccess.close();

        /**
         * new adapter linked to spinner


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);

        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /**get the names selected
                String name = names.get(position);
                /**opening database
                databaseAccess.open();

                /** image is retrieved as byte

                byte[] data = databaseAccess.getImages(name);

                /** image is converted to bitmap
                Bitmap image = toBitmap(data);

                /** setting the bitmap image to imageV
                imgPlace.setImageBitmap(image);

                /** closing database
                databaseAccess.close();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            /**
             * source: https://www.javahelps.com/2016/04/import-database-with-images-in-android.html



        });
    }

    public static Bitmap toBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}

*/
