package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCurrentAlarmsActivity extends AppCompatActivity {
    ArrayList<AlarmInfo> alarms;
    TextView alarmList;
    LinearLayout menu;
    boolean menuVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_alarms);
        alarms = (ArrayList<AlarmInfo>) getIntent().getSerializableExtra("key");
        alarmList = findViewById(R.id.alarmList);
        for (AlarmInfo a :alarms) {
           alarmList.append("\n" + a.name);
        }
        menu = findViewById(R.id.menu);
        menuVisible = false;
    }

    public void displayMenu(View view) {
        if (menuVisible) {
            menu.setVisibility(View.GONE);
            menuVisible = false;
        } else {
            menu.setVisibility(View.VISIBLE);
            menuVisible = true;
        }
    }

    public void viewHome(View view) {
        Log.d("viewHome", "viewHome called");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", alarms);
        startActivity(intent);
    }
    public void viewAlarms(View view) {
        menu.setVisibility(View.GONE);
        menuVisible = false;
    }
    public void viewNew(View view) {
        Log.d("viewNew", "viewNew called");
        Intent intent = new Intent(this, NewAlarmActivity.class);
        intent.putExtra("key", alarms);
        startActivity(intent);
    }
}
