package com.example.jason.androidintroductionexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jason.androidintroductionexample.CustomizeService.BindServiceActivity;
import com.example.jason.androidintroductionexample.CustomizeService.MyBroadcastReceiver;
import com.example.jason.androidintroductionexample.CustomizeService.ServiceActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "  ---->  onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "  ---->  onResume!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "  ---->  onRestart!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "  ---->  onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "  ---->  onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "  ---->  onDestroy!");
    }

    public void startCustomizeService(View view) {
        Log.e(TAG, "  ---->  StartCustomizeService!");
        startActivity(new Intent(this, ServiceActivity.class));
    }

    public void startCustomizeBindService(View view) {
        Log.e(TAG, "  ---->  StartBindService!");
        startActivity(new Intent(this, BindServiceActivity.class));
    }

    public void startBroadcastReceiver(View view) {
        Log.e(TAG, "  ---->  startBroadcastReceiver!");

        Intent mIntent = new Intent(this, MyBroadcastReceiver.class);
        mIntent.setAction("show.message.HELLO_MYSELF");
        PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, 1, mIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Hello MyBroadcastReceiver")
                .setContentTitle("Hello")
                .setContentIntent(mPendingIntent);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


}
