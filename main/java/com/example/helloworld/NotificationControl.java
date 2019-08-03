package com.example.helloworld;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class NotificationControl {
    NotificationManager alarmNotificationManager;
    Context main;

    public NotificationControl(Context main) {
        this.main=main;
        alarmNotificationManager = (NotificationManager) main.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void sendNotification(String message) {
        NotificationCompat.Builder alarmNotificationBuilder = new NotificationCompat.Builder(
                main, "notifications").setContentTitle("Alarm")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentText(message);
        alarmNotificationManager.notify(1, alarmNotificationBuilder.build());
    }
}
