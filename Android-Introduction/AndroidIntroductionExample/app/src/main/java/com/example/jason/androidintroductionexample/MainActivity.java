package com.example.jason.androidintroductionexample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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


}
