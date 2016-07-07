package com.example.jason.opps_concept.OPPsConcept.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jason.opps_concept.Login.VLogin;
import com.example.jason.opps_concept.R;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private static final String PRE_NAME = "LOGIN";
    private static final String EMAIL = "EMAIL";
    private static final String LOGIN = "LOGIN";

    private TextView tvHelloUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloUser = (TextView) findViewById(R.id.textView_hello);
        mPreferences = getSharedPreferences(PRE_NAME, MODE_PRIVATE);
        tvHelloUser.setText("Hello, " + mPreferences.getString(EMAIL, "Jason") + "!");
    }

    public void onclickStartOOP(View v){
        customStartActivity(CheckSalaryActivity.class);
    }

    public void onclickStartMultiThread(View v){
        customStartActivity(RunnableInterface.class);
    }

    public void onclickLogout(View v){
        mPreferences = getSharedPreferences(PRE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor e = mPreferences.edit();
        e.putBoolean(LOGIN, false);
        e.commit();
        customStartActivity(VLogin.class);
    }

    public void customStartActivity(Class mClass){
        Intent mIntent = new Intent(this, mClass);
        startActivity(mIntent);
    }
}
