package com.example.nadin.fitness_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import static android.graphics.Color.GRAY;

public class Main51Activity extends AppCompatActivity {

    private int[] yData= {24, 10, 34, 34, 26, 67};
    private String[] xData = {"a", "b", "c", "d", "e", "f"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main51);

        pieChart = (PieChart)findViewById(R.id.idPieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(25);
        pieChart.setCenterText("Usage Statistics");
        pieChart.setCenterTextSize(10);

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    private void addDataSet (){
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();


        for(int i=0; i<yData.length; i++){
            yEntry.add(new PieEntry(yData[i], i ));

        }

        for (int i =1; i<xData.length; i++){
            xEntry.add(xData[i]);
        }

        //creating the dataset
        PieDataSet pieDataSet = new PieDataSet(yEntry, "type of exercise");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add data colours

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.MAGENTA);
        colors.add(Color.BLUE);
        colors.add(Color.GRAY);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);
        colors.add(Color.GREEN);

        pieDataSet.setColors(colors);

        //adding a legend

        Legend legend= pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);

        // create the pie chart data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();





    }
}


/**
 sources: https://github.com/PhilJay/MPAndroidChart
          https://github.com/mitchtabian/Pie-Chart-Tutorial

 */