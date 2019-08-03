package com.example.helloworld;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity {
    Button button;
    TimePicker alarmTimePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    EditText alarmName;
    ArrayList<AlarmInfo> alarms;
    LinearLayout menu;
    boolean menuVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_alarm);
        alarms = (ArrayList<AlarmInfo>) getIntent().getSerializableExtra("key");
        button = findViewById(R.id.button);
        alarmTimePicker = findViewById(R.id.alarmTimePicker);
        alarmName = findViewById(R.id.alarmMessage);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
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

    public void setAlarm(View view) {
        System.out.println("Hello, button pressed");
        //button.setText("button was clicked");
        //setAlarm(alarmTimePicker.getCurrentHour(), alarmTimePicker.getCurrentMinute());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        alarms.add(new AlarmInfo(alarmName.getText().toString(), calendar));
        Intent myIntent = new Intent(NewAlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(NewAlarmActivity.this, 0, myIntent, 0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        Log.d("NewAlarmActivity", "set alarm");
    }

    public void viewHome(View view) {
        Log.d("viewHome", "viewHome called");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", alarms);
        startActivity(intent);
    }
    public void viewAlarms(View view) {
        Log.d("viewAlarms", "viewAlarms has been called");
        Intent intent = new Intent(this, ViewCurrentAlarmsActivity.class);
        intent.putExtra("key", alarms);
        startActivity(intent);
    }
    public void viewNew(View view) {
        menu.setVisibility(View.GONE);
        menuVisible = false;
    }
}
