package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();


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
                int counterChest1 = preferences.getInt("counterChest1", 0);
                counterChest1 = counterChest1 + 1;
                edit.putInt("counterChest1", counterChest1).commit();
            }
        });

        che2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterChest2 = preferences.getInt("counterChest2", 0);
                counterChest2 = counterChest2 + 1;
                edit.putInt("counterChest2", counterChest2).commit();
            }
        });

        che3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterChest3 = preferences.getInt("counterChest3", 0);
                counterChest3 = counterChest3 + 1;
                edit.putInt("counterChest3", counterChest3).commit();
            }
        });

        che4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterChest4 = preferences.getInt("counterChest4", 0);
                counterChest4 = counterChest4 + 1;
                edit.putInt("counterChest4", counterChest4).commit();
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
