package com.example.nadin.fitness_app;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main20Activity extends AppCompatActivity {
    private Button start, cancel;
    private CountDownTimer countTimer;
    private TextView time;



    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start:
                    start();
                    break;
                case R.id.cancel:
                    cancel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(clickListener);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(clickListener);
        time = (TextView) findViewById(R.id.time);
    }

    private void start() {
        time.setText("30");

         countTimer = new CountDownTimer(30 * 1000, 1000) {
            @Override
            public void onTick(long millsTillFinish) {
                time.setText("" + millsTillFinish / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("Done");
            }
        };
         countTimer.start();
    }


    private void cancel() {
        if (countTimer != null) {
            countTimer.cancel();
            countTimer = null;
        }
    }


}

/**
 * source:https://developer.android.com/reference/android/os/CountDownTimer
 */