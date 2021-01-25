package com.lyadev.watercondition;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;

import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;



public class NotifyService extends Service {
    NotificationManager nm;

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        sendNotif();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    void sendNotif() {


        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR, 5);
        cal.set(Calendar.MINUTE, 24);
//        Notification notif = new Notification(R.mipmap.ic_launcher, "Text in status bar",
//                System.currentTimeMillis());
     NotificationCompat.WearableExtender wearableExtender =
              new NotificationCompat.WearableExtender()
                     .setHintShowBackgroundOnly(true);


        NotificationCompat.Builder notification =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Hello Android Wear")
                        .setContentText("First Wearable notification.")
                        .setContentIntent(pIntent);

//        NotificationManagerCompat notificationManager =
//                NotificationManagerCompat.from(this);
//NotificationManager nt = (NotificationManager) getSystemService(.NOTIFICATION_SERVICE);
        int notificationId = 0;

      //nt.notify(notificationId, notification.build());




        // Enables Always-on

        //alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pIntent);
    }

    public IBinder onBind(Intent arg0) {
        sendNotif();
        return null;
    }
}
