package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlarmManager;
import android.provider.AlarmClock;
import android.content.Intent;
import android.widget.TimePicker;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    Button button;
    TimePicker alarmTimePicker;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        alarmTimePicker = findViewById(R.id.alarmTimePicker);
        //alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
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

        setAlarm(alarmTimePicker.getCurrentHour(), alarmTimePicker.getCurrentMinute());

    }
}
