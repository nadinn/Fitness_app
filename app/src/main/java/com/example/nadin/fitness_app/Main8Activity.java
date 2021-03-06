/**
 * ABS EXERCISE ACTIVITY
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

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();

        // creating new buttons
        ImageButton abs1 = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton abs2 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton abs3 = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton abs4 = (ImageButton) findViewById(R.id.imageButton11);
        Button go = (Button) findViewById(R.id.go);
        Button go1 = (Button) findViewById(R.id.go1);
        Button go2 = (Button) findViewById(R.id.go2);
        Button go3 = (Button) findViewById(R.id.go3);

        // setting on click listeners for all the buttons
         abs1.setOnClickListener(new View.OnClickListener(){
        @Override public void onClick(View view){
        Intent start = new Intent(getApplicationContext(), Main20Activity.class);
        startActivity(start);

            int counterAbs1 = preferences.getInt("counterAbs1", 0);
            counterAbs1 = counterAbs1 + 1;
            edit.putInt("counterAbs1", counterAbs1).commit();

        }
        });

        abs2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterAbs2 = preferences.getInt("counterAbs2", 0);
                counterAbs2 = counterAbs2 + 1;
                edit.putInt("counterAbs2", counterAbs2).commit();

            }
        });

        abs3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterAbs3 = preferences.getInt("counterAbs3", 0);
                counterAbs3 = counterAbs3 + 1;
                edit.putInt("counterAbs3", counterAbs3).commit();
            }
        });

        abs4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main20Activity.class);
                startActivity(start);

                int counterAbs4 = preferences.getInt("counterAbs4", 0);
                counterAbs4 = counterAbs4 + 1;
                edit.putInt("counterAbs4", counterAbs4).commit();
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main21Activity.class);
                startActivity(start);
            }
        });

        go1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main22Activity.class);
                startActivity(start);
            }
        });

        go2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main23Activity.class);
                startActivity(start);
            }
        });

        go3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent start = new Intent(getApplicationContext(), Main24Activity.class);
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
