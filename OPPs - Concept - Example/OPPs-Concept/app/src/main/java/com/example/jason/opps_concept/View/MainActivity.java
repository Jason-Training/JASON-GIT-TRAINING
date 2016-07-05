package com.example.jason.opps_concept.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jason.opps_concept.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickStartOOP(View v){
        customStartActivity(CheckSalaryActivity.class);
    }

    public void onclickStartMultiThread(View v){
        customStartActivity(RunnableInterface.class);
    }

    public void customStartActivity(Class mClass){
        Intent mIntent = new Intent(this, mClass);
        startActivity(mIntent);
    }
}
