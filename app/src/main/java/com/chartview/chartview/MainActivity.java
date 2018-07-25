package com.chartview.chartview;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.chartview.view.LineWPChartView;

public class MainActivity extends AppCompatActivity {

    private LineWPChartView lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lin = findViewById(R.id.line);

    }


}
