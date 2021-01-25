package com.lyadev.watercondition;


import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.RequiresApi;

import java.util.Calendar;


public class MainActivity extends WearableActivity {

    public static final String FILE_NAME = "File name";
    private static final String TAG = "MAIN_ACTIVITY";
    private TextView mTextView;
    private ProgressBar progressbar;
    private ImageButton button;
    private ImageButton refresh_button;
    private ImageButton setting_button;
    private SharedPreferences _savestate;
    private final String DAY_PROGRESS = "day_progress";
    private int progressbar_progress;
    Intent settings_activity;

    BroadcastReceiver br;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent service = new Intent(this, Alarm_service.class);
        this.startService(service);
        service.putExtra("DATE", 25);


        Log.e(TAG,"Starting...");

        loadstate();
        mTextView = (TextView) findViewById(R.id.textView);
        progressbar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        setting_button = findViewById(R.id.setting_button);
        refresh_button = findViewById(R.id.refresh_progress);
        progressbar.setProgress(progressbar_progress);
        mTextView.setText(progressbar.getProgress()+"%");
        settings_activity = new Intent(this, SettingActivity.class);

        setting_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    startActivity(settings_activity);
                }

                return false;
            }
        });
        refresh_button.setOnTouchListener(new View.OnTouchListener(){


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    progressbar.setProgress(0);
                    mTextView.setText("0%");
                }
                return false;
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {

            //@Override
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event) { if (event.getAction() == MotionEvent.ACTION_DOWN) {
                   progressbar.setProgress(progressbar.getProgress()+10);
                   mTextView.setText(progressbar.getProgress()+"%");
                   return true;
                }
                return false;
            }
        });
        setAmbientEnabled();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        savestate();

        super.onStop();
    }

    void savestate(){
        _savestate = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = _savestate.edit();
        editor.putInt(DAY_PROGRESS, progressbar.getProgress());
        editor.commit();
    }
    void loadstate(){
        _savestate = getPreferences(MODE_PRIVATE);
        progressbar_progress =  _savestate.getInt(DAY_PROGRESS, 0);
    }

}