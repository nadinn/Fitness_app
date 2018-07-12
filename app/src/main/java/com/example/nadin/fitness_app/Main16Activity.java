/**
 * activity used to retrieve user inputs from two EdtiTexts and store
 * them in two separate arrays : addArray and addArray2 (kg and dates recorded)
 * the elements from the first array are displayed in the ListView
 * NEXT STEP:
 * -use simple adapter instead of array adapter in order to show elements of
 * both arrays in the ListView
 * -save the arrays in shared preferences or database
 * -use a date format for the second array
 * -open the ListView in a different activity (optional)
 * retrieve all the saved inputs and use them to plot the graph
 */

package com.example.nadin.fitness_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main16Activity extends AppCompatActivity {
    EditText weight;
    EditText date;
    Button submit;
    Button buttonList;
    ListView list;
    //ListView list2;
    ArrayList <String> addArray = new ArrayList<String>();
    ArrayList <String> addArray2 = new ArrayList<String>();
    //List<Map<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        /**
         * initialising EditText, Button and ListView
         */
        weight= (EditText ) findViewById(R.id.text1);
        date = (EditText) findViewById(R.id.text2);
        submit = (Button) findViewById(R.id.submitButton);
        //buttonList = (Button) findViewById(R.id.buttonList);
        list = (ListView) findViewById(R.id.dynamic);
        //ArrayAdapter<String> adapter;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * get text from input fields
                 */
                String getInput = weight.getText().toString();
                String getInput2 =date.getText().toString();

                /**
                 * if the input is null show a notifying message
                 */
                if (getInput == null || getInput2 == null){
                    Toast.makeText(getBaseContext(), "No item inserted", Toast.LENGTH_LONG).show();
                }

                /**
                 * else adding the getInput and getInput2 to the two arrays
                 */
                else{
                    addArray.add(getInput);
                    addArray2.add(getInput2);
                    /**
                     * creating an adapter for ListView and populating it with the
                     * elements from the first array
                     */
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main16Activity.this, android.R.layout.simple_list_item_1, addArray);
                    //SimpleAdapter adapter2 = new SimpleAdapter(Main16Activity.this, data, R.layout.activity_main16, new String[]{"Weight: ", "Date: "}, new int [] {R.id.text1, R.id.text2});
                     list.setAdapter(adapter);
                    ((EditText)findViewById(R.id.text1)).setText(" ");
                    ((EditText) findViewById(R.id.text2)).setText(" ");
                    //startActivityForResult(new Intent(Main16Activity.this, ListTest.class), 1);

                }
            }
        });
/**
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start;
                start= new Intent(getApplicationContext(), ListTest.class);
                startActivity(start);
            }
        });

*/

    }
}
