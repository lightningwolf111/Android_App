package com.example.helloworld;


import java.util.Calendar;

public class AlarmInfo implements java.io.Serializable{
    Calendar calendar = Calendar.getInstance();
    String name = "Alarm";
    AlarmInfo(String name) {
       this.name = name;
    }
    AlarmInfo(Calendar c) {
        calendar = c;
    }
    AlarmInfo(String name, Calendar c) {
        calendar = c;
        this.name = name;
    }
}
