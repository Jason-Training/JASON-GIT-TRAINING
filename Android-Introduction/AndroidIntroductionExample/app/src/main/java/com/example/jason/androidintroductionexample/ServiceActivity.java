package com.example.jason.androidintroductionexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {
    private static final String TAG = "ServiceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
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
    // Method to start the service
    public void onclickStartService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Method to stop the service
    public void onclickStopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

}
