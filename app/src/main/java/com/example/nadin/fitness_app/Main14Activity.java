package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main14Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        // creating new buttons
        ImageButton tri1 = (ImageButton) findViewById(R.id.imageButton32);
        ImageButton tri2 = (ImageButton) findViewById(R.id.imageButton33);
        ImageButton tri3 = (ImageButton) findViewById(R.id.imageButton34);
        ImageButton tri4 = (ImageButton) findViewById(R.id.imageButton35);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);

        // setting on click listeners for all the buttons
        tri1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        tri2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        tri3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        tri4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main41Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main42Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main43Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main44Activity.class);
                startActivity(start);
            }
        });
    }
}
