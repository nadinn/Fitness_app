/**
 * TRICEPS EXERCISE ACTIVITY
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

public class Main14Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();

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
                int counterTri1 = preferences.getInt("counterTri1", 0);
                counterTri1 = counterTri1 + 1;
                edit.putInt("counterTri1", counterTri1).commit();
            }
        });

        tri2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterTri2 = preferences.getInt("counterTri2", 0);
                counterTri2 = counterTri2 + 1;
                edit.putInt("counterTri2", counterTri2).commit();
            }
        });

        tri3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterTri3 = preferences.getInt("counterTri3", 0);
                counterTri3 = counterTri3 + 1;
                edit.putInt("counterTri3", counterTri3).commit();
            }
        });

        tri4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterTri4 = preferences.getInt("counterTri4", 0);
                counterTri4 = counterTri4 + 1;
                edit.putInt("counterTri4", counterTri4).commit();
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
