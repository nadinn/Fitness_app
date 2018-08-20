/**
 * BACK EXERCISE ACTIVITY
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

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();


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

                int counterBack1 = preferences.getInt("counterBack1", 0);
                counterBack1 = counterBack1 + 1;
                edit.putInt("counterBack1", counterBack1).commit();
            }
        });

        back2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterBack2 = preferences.getInt("counterBack2", 0);
                counterBack2 = counterBack2 + 1;
                edit.putInt("counterBack2", counterBack2).commit();
            }
        });

        back3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterBack3 = preferences.getInt("counterBack3", 0);
                counterBack3 = counterBack3 + 1;
                edit.putInt("counterBack3", counterBack3).commit();
            }
        });

        back4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterBack4 = preferences.getInt("counterBack4", 0);
                counterBack4 = counterBack4 + 1;
                edit.putInt("counterBack4", counterBack4).commit();
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

/**
 Adapted from :
 Emulator S. SharedPreferences and Emulator [Internet]. Stack Overflow. 2018 [cited 15 July 2018].
 Available from: https://stackoverflow.com/questions/12779605/sharedpreferences-and-emulator

 Save key-value data | Android Developers [Internet]. Android Developers. 2018 [cited 15 July 2018].
 Available from: https://developer.android.com/training/data-storage/shared-preferences
 */
