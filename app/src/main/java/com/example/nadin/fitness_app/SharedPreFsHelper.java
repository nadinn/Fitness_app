/** NOT IN USE
 *

package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import static com.example.nadin.fitness_app.SharedPrefConstants.DEFAULT_KEY;
import static com.example.nadin.fitness_app.SharedPrefConstants.EDIT_WEIGHT;

interface SharedPrefConstants {
    String DEFAULT_KEY = "default_key";
    String EDIT_WEIGHT = "editWeight";
}

public class SharedPreFsHelper implements SharedPrefConstants {

    public static void setEditWeight (Context context, String length) {
        SharedPreferences sp = context.getSharedPreferences(DEFAULT_KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(EDIT_WEIGHT, length);
        editor.commit();
    }

    public static String getEditWeight (Context context) {
        SharedPreferences sp = context.getSharedPreferences(DEFAULT_KEY, 0);
        return sp.getString(EDIT_WEIGHT, "");
    }


}
 /**
  source https://stackoverflow.com/questions/38339982/save-number-input-from-edittext-into-sharedpreferences/38340272
  */