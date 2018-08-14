/**
 * GLUTES EXERCISE ACTIVITY
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

public class Main12Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();

        // creating new buttons
        ImageButton glu1 = (ImageButton) findViewById(R.id.imageButton24);
        ImageButton glu2 = (ImageButton) findViewById(R.id.imageButton25);
        ImageButton glu3 = (ImageButton) findViewById(R.id.imageButton26);
        ImageButton glu4 = (ImageButton) findViewById(R.id.imageButton27);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);

        // setting on click listeners for all the buttons
        glu1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterGlutes1 = preferences.getInt("counterGlutes1", 0);
                counterGlutes1 = counterGlutes1 + 1;
                edit.putInt("counterGlutes1", counterGlutes1).commit();
            }
        });

        glu2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterGlutes2 = preferences.getInt("counterGlutes2", 0);
                counterGlutes2 = counterGlutes2 + 1;
                edit.putInt("counterGlutes2", counterGlutes2).commit();
            }
        });

        glu3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterGlutes3 = preferences.getInt("counterGlutes3", 0);
                counterGlutes3 = counterGlutes3 + 1;
                edit.putInt("counterGlutes3", counterGlutes3).commit();
            }
        });

        glu4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);
                int counterGlutes4 = preferences.getInt("counterGlutes4", 0);
                counterGlutes4 = counterGlutes4 + 1;
                edit.putInt("counterGlutes4", counterGlutes4).commit();
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main37Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main38Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main39Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main40Activity.class);
                startActivity(start);
            }
        });
    }
}
