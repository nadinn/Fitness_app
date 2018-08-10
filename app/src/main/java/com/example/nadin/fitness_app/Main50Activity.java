package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main50Activity extends AppCompatActivity {
    TextView t1;
    int counter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main50);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics", Context.MODE_PRIVATE);
        counter1 = preferences.getInt("counter1", 0);
        t1=(TextView)findViewById(R.id.textView8);
        t1.setText(String.valueOf(counter1));


        /**
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value1 = extras.getInt("key1");




        }
         */



    }
}
