/**TEST ACTIVITY FOR DATABASE IMPLEMENTATION - NOT IN USE
 *
 *

package com.example.nadin.fitness_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;



public class Main3Activity extends AppCompatActivity {
    private ListView list1;

    /**
     * Called when the activity is first created.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       /** this.list1 = (ListView) findViewById(R.id.list1);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getQuotes();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.list1.setAdapter(adapter);


    }
}
*/