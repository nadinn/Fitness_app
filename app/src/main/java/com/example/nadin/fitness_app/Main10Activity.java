/**
 * BICEPS EXERCISE ACTIVITY
 */

package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();


        // creating new buttons
        ImageButton bi1 = (ImageButton) findViewById(R.id.imageButton16);
        ImageButton bi2 = (ImageButton) findViewById(R.id.imageButton17);
        ImageButton bi3 = (ImageButton) findViewById(R.id.imageButton18);
        ImageButton bi4 = (ImageButton) findViewById(R.id.imageButton19);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);

        // setting on click listeners for all the buttons
        bi1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterBi1 = preferences.getInt("counterBi1", 0);
                counterBi1 = counterBi1 + 1;
                edit.putInt("counterBi", counterBi1).commit();
            }
        });

        bi2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterBi2 = preferences.getInt("counterBi2", 0);
                counterBi2 = counterBi2 + 1;
                edit.putInt("counterBi2", counterBi2).commit();
            }
        });

        bi3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterBi3 = preferences.getInt("counterBi3", 0);
                counterBi3 = counterBi3 + 1;
                edit.putInt("counterBi3", counterBi3).commit();
            }
        });

        bi4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterBi4 = preferences.getInt("counterBi4", 0);
                counterBi4 = counterBi4 + 1;
                edit.putInt("counterBi4", counterBi4).commit();
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main29Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main30Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main31Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main32Activity.class);
                startActivity(start);
            }
        });

    }
}
