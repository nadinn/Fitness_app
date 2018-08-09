package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Preferences {
    private static final String APP_PREFS = "AppPrefsFile";
    private static final String NUMBER_OF_CLICKS = "numberOfClicks";

    private SharedPreferences sharedPrefs;
    private static Preferences instance;

    private Preferences(Context context) {
        sharedPrefs =
                context.getApplicationContext().getSharedPreferences(APP_PREFS, MODE_PRIVATE);
    }


    public static synchronized Preferences getInstance(Context context) {
        if (instance == null)
            instance = new Preferences(context);

        return instance;
    }

    public void increaseClickCount() {
        int clickCount = sharedPrefs.getInt(NUMBER_OF_CLICKS, 0);
        clickCount++;
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(NUMBER_OF_CLICKS, clickCount);
        editor.apply();
    }
}
