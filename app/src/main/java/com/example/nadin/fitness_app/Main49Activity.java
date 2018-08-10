/**
 * activity for testing sharedPreferences
 */

package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Main49Activity extends AppCompatActivity {
    Button update, update2, send;
    TextView t1, t2;
    int counter1, counter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main49);


        t1 = (TextView) findViewById(R.id.textCount);
        t2 = (TextView) findViewById(R.id.textView9);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();
        //t1.setText(String.valueOf(preferences.getInt("counter",0)));
        counter1 = preferences.getInt("counter1", 0);
        counter2 = preferences.getInt("counter2", 0);
        t1.setText(String.valueOf(counter1));
        t2.setText(String.valueOf(counter2));


        update = (Button) findViewById(R.id.button13);
        update2 = (Button) findViewById(R.id.button14);
        send = (Button) findViewById(R.id.button15);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main50Activity.class);
                startActivity(start);

            }

        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter1 = preferences.getInt("counter1", 0);
                counter1 = counter1 + 1;
                edit.putInt("counter1", counter1).commit();
                //String strCounter = Integer.toString(counter);
                //t1.setText(strCounter);

            }
        });


        update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter2 = preferences.getInt("counter2", 0);
                counter2 = counter2 + 1;
                edit.putInt("counter2", counter2).commit();

            }
        });

    }

}
/**
        int value1=counter1;
        Intent i = new Intent(Main49Activity.this, Main50Activity.class);
        i.putExtra("key1",value1);
        startActivity(i);

    }



}

/**
 * source: https://stackoverflow.com/questions/12779605/sharedpreferences-and-emulator
 * https://developer.android.com/training/data-storage/shared-preferences
 *
 */
