package com.example.muhib.capurescreen;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.util.Log;



/**
 * Created by RR on 05-Apr-18.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    private static AlarmManager am;
    private static PendingIntent pendingIntent;
    private static Intent intent1;
    private static int ALARM_CODE = 1111;



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

}
