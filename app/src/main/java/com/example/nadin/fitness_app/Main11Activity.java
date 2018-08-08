package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        // creating new buttons
        ImageButton che1 = (ImageButton) findViewById(R.id.imageButton20);
        ImageButton che2 = (ImageButton) findViewById(R.id.imageButton21);
        ImageButton che3 = (ImageButton) findViewById(R.id.imageButton22);
        ImageButton che4 = (ImageButton) findViewById(R.id.imageButton23);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);


        // setting on click listeners for all the buttons
        che1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        che2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        che3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        che4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main33Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main34Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main35Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main36Activity.class);
                startActivity(start);
            }
        });

    }
}
