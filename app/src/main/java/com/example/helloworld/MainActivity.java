package com.example.helloworld;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.AlarmManager;
import android.provider.AlarmClock;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    Button button;
    TimePicker alarmTimePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Button viewAlarms;
    EditText alarmName;
    ArrayList<AlarmInfo> alarms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        viewAlarms = findViewById(R.id.view_alarms);
        alarmTimePicker = findViewById(R.id.alarmTimePicker);
        alarmName = findViewById(R.id.alarmMessage);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }


    public void setAlarm(int hours,int minutes){
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "It's about time!");
        i.putExtra(AlarmClock.EXTRA_HOUR, hours);
        i.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        startActivity(i);

    }

    public void setAlarm(View view) {
        System.out.println("Hello, button pressed");
        button.setText("button was clicked");
        //setAlarm(alarmTimePicker.getCurrentHour(), alarmTimePicker.getCurrentMinute());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        alarms.add(new AlarmInfo(alarmName.getText().toString(), calendar));
        Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        Log.d("MainActivity", "set alarm");
    }
    public void viewAlarms(View view) {
        Log.d("viewAlarms", "viewAlarms has been called");
        Intent intent = new Intent(this, ViewCurrentAlarmsActivity.class);
        intent.putExtra("key", alarms);
        startActivity(intent);
    }
}
