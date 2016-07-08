package com.example.jason.androidintroductionexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jason on 08/07/2016.
 */
public class MyBindService extends Service {

    private static final String TAG = "BindService";
    private final IBinder iBinder = new LocalService();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, " ---> onCreate!");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, " ---> onStart!");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, " ---> onBind!");
        return iBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, " ---> onDestroy!");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, " ---> onUnbind!");
        return super.onUnbind(intent);
    }


    public class LocalService extends Binder{
        MyBindService getService(){
            Log.e(TAG, " ---> return BindService!");
            return MyBindService.this;
        }
    }

    public String getFirstMessage(){
        Log.e(TAG, " ---> return FirstMessage!");
        return "This is the first Message";
    }

    public String getSecondMessage(){
        Log.e(TAG, " ---> return FirstMessage!");
        return "This is the first Message";
    }
}
