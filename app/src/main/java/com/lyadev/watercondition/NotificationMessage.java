package com.lyadev.watercondition;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationMessage {
    MainActivity ma = new MainActivity();
    public void NotificationMessage(Context context) {

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintShowBackgroundOnly(true);

        Notification notification =
                new NotificationCompat.Builder(ma)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Hello Android Wear")
                        .setContentText("First Wearable notification.")
                        .extend(wearableExtender)
                        .build();

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(ma);

        int notificationId = 1;


        notificationManager.notify(notificationId, notification);
    }
}
