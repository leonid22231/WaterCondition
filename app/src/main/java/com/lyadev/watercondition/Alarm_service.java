package com.lyadev.watercondition;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.BitSet;
import java.util.Calendar;

public class Alarm_service extends Service {

    private static final Calendar cal = Calendar.getInstance();
    private static final String TAG = "SERVICE";
    Intent intent1;
    static PendingIntent Pintent;
    static AlarmManager alarm;
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind" );
        System.out.println("START");
        return null;
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "Create");
        super.onCreate();
    }

    public Alarm_service() {
        super();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        intent1 = new Intent(this, Notificationreciver.class);
        Pintent = PendingIntent.getBroadcast(this,0,intent1,PendingIntent.FLAG_CANCEL_CURRENT);



        alarm  = (AlarmManager) getSystemService(ALARM_SERVICE);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (intent !=null && intent.getExtras()!=null){
            String value = intent.getExtras().getString("DATE");
        }
    }



    public static void times(int hours, int minute, int second){


    }

    public static void new_alarm(int hours, int minute, int second){



//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, hours);
//        calendar.set(Calendar.MINUTE, minute);
//        calendar.set(Calendar.SECOND, second);
//        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),Pintent);
//        Log.e(TAG, Calendar.getInstance().getTime().toString());
    }

}
