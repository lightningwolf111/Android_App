package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCurrentAlarmsActivity extends AppCompatActivity {
    ArrayList<AlarmInfo> alarms;
    TextView alarmList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_alarms);
        alarms = (ArrayList<AlarmInfo>) getIntent().getSerializableExtra("key");
        alarmList = findViewById(R.id.alarmList);
        for (AlarmInfo a :alarms) {
           alarmList.append("\n" + a.name);
        }
    }
}
