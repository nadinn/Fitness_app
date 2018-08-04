package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        // creating new buttons
        ImageButton abs1 = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton abs2 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton abs3 = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton abs4 = (ImageButton) findViewById(R.id.imageButton11);

        // setting on click listeners for all the buttons
         abs1.setOnClickListener(new View.OnClickListener(){
        @Override public void onClick(View view){
        Intent start = new Intent(getApplicationContext(), Main20Activity.class);
        startActivity(start);
        }
        });

        abs2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        abs3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        abs4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });







    }


}
