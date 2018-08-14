/**
 * PIE-CHART ACTIVITY
 */

package com.example.nadin.fitness_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;



public class Main51Activity extends AppCompatActivity {

    private static String TAG = "Main51Activity";

    //private int[] yData ={22, 10, 37, 24, 26, 10};
    private String[] xData = {"Abs", "Back", "Biceps", "Chest", "Glutes", "Quads" , "Triceps"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main51);

        // retrieving the data from sharesPreferences and assigning variables
        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("counterStatistics2", Context.MODE_PRIVATE);
        int abs = preferences.getInt("counterAbs1", 0)+preferences.getInt("counterAbs2", 0)+
                preferences.getInt("counterAbs3", 0)+preferences.getInt("counterAbs4", 0);
        int back = preferences.getInt("counterBack1", 0) + preferences.getInt("counterBack2", 0)+
                preferences.getInt("counterBack3", 0)+preferences.getInt("counterBack4", 0);
        int biceps = preferences.getInt("counterBi1", 0) + preferences.getInt("counterBi2", 0) +
                preferences.getInt("counterBi3", 0) +preferences.getInt("counterBi4", 0);
        int chest = preferences.getInt("counterChest1", 0)+preferences.getInt("counterChest2", 0)+
                preferences.getInt("counterChest3", 0)+preferences.getInt("counterChest4", 0);
        int glutes = preferences.getInt("counterGlutes1", 0) + preferences.getInt("counterGlutes2", 0)+
                preferences.getInt("counterGlutes3", 0)+preferences.getInt("counterGlutes4", 0);
        int quads = preferences.getInt("counterQuads1", 0)+preferences.getInt("counterQuads2", 0)+
                preferences.getInt("counterQuads3", 0)+preferences.getInt("counterQuads4", 0);
        int triceps = preferences.getInt("counterTri1", 0)+preferences.getInt("counterTri2", 0)+
                preferences.getInt("counterTri3", 0)+preferences.getInt("counterTri4", 0);

        //creating an array with the data retrieved

        int[] yData ={abs, back, biceps, chest, glutes, quads, triceps};

        // modifying the pie chart aesthetically

        pieChart = (PieChart)findViewById(R.id.pieChart1);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(20f);
        pieChart.setTransparentCircleAlpha(10);
        pieChart.setCenterText("Usage Statistics");
        pieChart.setCenterTextSize(15);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.animateY(2000, Easing.EasingOption.EaseOutCubic);



        ///////////////////////

        Log.d(TAG, "addDataSet started");

        // creating two new arrayLists
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();

        // adding the data from yData to a new arrayList and to the pie chart
        for(int i=0; i<yData.length; i++){
            yEntry.add(new PieEntry(yData[i], xData[i] ));
        }

        // adding the data from xData to a new arrayList
        for (int i =1; i<xData.length; i++){
            xEntry.add(xData[i]);
        }

        //creating the dataset
        PieDataSet pieDataSet = new PieDataSet(yEntry, "Type of exercise");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(17);


        //add data colours

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.DKGRAY);
        colors.add(Color.BLUE);
        colors.add(Color.GRAY);
        colors.add(Color.CYAN);
        colors.add(Color.RED);
        colors.add(Color.LTGRAY);
        colors.add(Color.GREEN);

        pieDataSet.setColors(colors);

        //adding a legend

        Legend legend= pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        pieChart.getLegend().setTextColor(Color.BLACK);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(17f);



        // create the pie chart data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
        pieData.setValueTextSize(15f);
        pieData.setValueTextColor(Color.BLACK);

        ///////////////////

    }
}




/**
 adapted from: https://github.com/PhilJay/MPAndroidChart
               https://github.com/mitchtabian/Pie-Chart-Tutorial
               https://stackoverflow.com/questions/12779605/sharedpreferences-and-emulator
 *             https://developer.android.com/training/data-storage/shared-preferences
 */

