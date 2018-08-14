/**
 * QUADS EXERCISE ACTIVITY
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

public class Main13Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();


        // creating new buttons
        ImageButton qu1 = (ImageButton) findViewById(R.id.imageButton28);
        ImageButton qu2 = (ImageButton) findViewById(R.id.imageButton29);
        ImageButton qu3 = (ImageButton) findViewById(R.id.imageButton30);
        ImageButton qu4 = (ImageButton) findViewById(R.id.imageButton31);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);

        // setting on click listeners for all the buttons
        qu1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterQuads1 = preferences.getInt("counterQuads1", 0);
                counterQuads1 = counterQuads1 + 1;
                edit.putInt("counterQuads1", counterQuads1).commit();
            }
        });

        qu2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterQuads2 = preferences.getInt("counterQuads2", 0);
                counterQuads2 = counterQuads2 + 1;
                edit.putInt("counterQuads2", counterQuads2).commit();
            }
        });

        qu3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterQuads3 = preferences.getInt("counterQuads3", 0);
                counterQuads3 = counterQuads3 + 1;
                edit.putInt("counterQuads3", counterQuads3).commit();
            }
        });

        qu4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterQuads4 = preferences.getInt("counterQuads4", 0);
                counterQuads4 = counterQuads4 + 1;
                edit.putInt("counterQuads4", counterQuads4).commit();
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
