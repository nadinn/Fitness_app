package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        // creating new buttons
        ImageButton back1 = (ImageButton) findViewById(R.id.imageButton12);
        ImageButton back2 = (ImageButton) findViewById(R.id.imageButton13);
        ImageButton back3 = (ImageButton) findViewById(R.id.imageButton14);
        ImageButton back4 = (ImageButton) findViewById(R.id.imageButton15);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);


        // setting on click listeners for all the buttons
        back1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        back2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        back3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        back4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main25Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main26Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main27Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main28Activity.class);
                startActivity(start);
            }
        });

    }
}
