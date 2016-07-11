package com.example.jason.androidintroductionexample.CustomizeService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jason.androidintroductionexample.R;

public class BindServiceActivity extends AppCompatActivity {
    private static final String TAG = "BindServiceActivity";
    private MyBindService myBindService;
    private boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindservice);

        Intent mIntent = new Intent(this, MyBindService.class);
        getApplicationContext().bindService(mIntent, serviceConnection, BIND_AUTO_CREATE);
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
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "  ---->  onDestroy!");
    }


    public void getFirstMessage(View view) {
        String firstMessage = myBindService.getFirstMessage();
        Toast.makeText(getApplicationContext(), firstMessage, Toast.LENGTH_LONG).show();
    }

    public void getSecondMessage(View view) {
        String secondMessage = myBindService.getSecondMessage();
        Toast.makeText(getApplicationContext(), secondMessage, Toast.LENGTH_LONG).show();
    }

    public void unBindService(View view) {
        if (isBind){
            Log.e(TAG, "  ---->  unBindService!");
            getApplicationContext().unbindService(serviceConnection);
            isBind = false;
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindService.LocalService localService = (MyBindService.LocalService) service;
            myBindService = localService.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "  ---->  onStop!");
//        if (isBind){
////            unbindService(serviceConnection);
////            isBind = false;
//        }
    }
}
