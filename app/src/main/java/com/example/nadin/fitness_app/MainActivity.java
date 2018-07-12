
package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         * creating button1 and finding it by id from xml
         */
        Button buttonA = (Button) findViewById(R.id.button1);

        /**
         * setting an onClick listener to the button for new Activity
         */
        buttonA.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                Intent start;
                start = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(start);

            }


        });
        /**
         * setting an onClick listener to the button for new Activity
         */

        Button buttonB = (Button) findViewById(R.id.button2);
        buttonB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main7Activity.class);
                startActivity(start);

            }

        });
        /**
         * setting an onClick listener to the button for new Activity
         *
         * !!!!TESTING FOR DATABASE IMPLEMENTATION
         */

        Button buttonC = (Button) findViewById(R.id.button3);
        buttonC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main16Activity.class);
                startActivity(start);

            }

        });


    }
}





