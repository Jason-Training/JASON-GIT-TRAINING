package com.example.jason.androidintroductionexample.CustomizeService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jason on 08/07/2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "--->  onReceive!");
        if (intent.getAction().equals("show.message.HELLO_MYSELF")) {
            Toast.makeText(context, "Hello myself!", Toast.LENGTH_LONG).show();
        } else Toast.makeText(context, "Hello everyone!", Toast.LENGTH_LONG).show();
    }
}
