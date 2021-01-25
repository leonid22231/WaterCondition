package com.lyadev.watercondition;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
;

import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class Notificationreciver extends BroadcastReceiver {
    //public static final String CONTENT_KEY = "contentText";
    int id = 0;
    @Override
    public void onReceive(Context context, Intent intent) {
        Notification.Builder not = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Time to drink water!"+ Calendar.getInstance().getTime().toString())
                .setContentText("If you don't drink water, you can die)\n" + "You have left NaN ml")
                .setDefaults(Notification.DEFAULT_ALL);


        NotificationManager nt = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        nt.notify(id,not.build());
        id += 1;
    }




}
