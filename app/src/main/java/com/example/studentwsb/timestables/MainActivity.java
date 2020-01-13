package com.example.studentwsb.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;

    public void generateTimesTables( int timesTableNumber) {

        ArrayList<String> timesTAblesContent = new ArrayList<>();
        for (int j = 1; j<=10; j++) {
            timesTAblesContent.add(String.valueOf(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTAblesContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView =findViewById(R.id.timesTablesListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);
        generateTimesTables(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if (i<min) {
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }else {
                    timesTableNumber = i;
                }
                generateTimesTables(timesTableNumber);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
