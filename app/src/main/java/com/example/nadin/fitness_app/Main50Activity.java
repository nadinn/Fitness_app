package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main50Activity extends AppCompatActivity {
    TextView t1;
    int counter1;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main50);

        go=(Button)findViewById(R.id.button5);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start = new Intent(getApplicationContext(), Main51Activity.class);
                startActivity(start);

            }

        });


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
