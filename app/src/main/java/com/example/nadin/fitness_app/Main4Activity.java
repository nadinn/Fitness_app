/** TEST ACTIVITY - NOT IN USE */

package com.example.nadin.fitness_app;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    public String[] mainImages;
    public TypedArray images;
    public ImageView imageItem;

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        /** assigning the two variables the arrays created in strings.xml
          */

        mainImages = getResources().getStringArray(R.array.object_array);
        images = getResources().obtainTypedArray(R.array.object_image);

        /** creating a new textView and imageView
         * */

        TextView text1 = (TextView) findViewById(R.id.textView);
        imageItem = (ImageView) findViewById(R.id.imageView);

        /** creating the spinner
         * */

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, mainImages);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                imageItem.setImageResource(images.getResourceId(spinner.getSelectedItemPosition(), -1));

                /**  start another activity when selecting item from spinner items
                !!! WORK IN PROGRESS!!!!

                Intent intent = new Intent();
                switch (position){
                    case  :
                        intent = new Intent(Main4Activity.this, Main5Activity.class);
                        break;


                }
                startActivity(intent);*/
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }


}








