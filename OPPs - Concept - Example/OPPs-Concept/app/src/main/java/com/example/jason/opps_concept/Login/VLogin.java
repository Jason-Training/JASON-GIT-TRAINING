package com.example.jason.opps_concept.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason.opps_concept.OPPsConcept.View.MainActivity;
import com.example.jason.opps_concept.R;

/**
 * Created by jason on 01/07/2016.
 */
public class VLogin extends AppCompatActivity implements iLoginView{

    private EditText edtEmail = null, edtPassword = null;
//    private TextView tvSignup = null;
    private CheckBox cbRemember = null;
    private PLogin mPLogin = null;
    private static final String PRE_NAME = "LOGIN";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private static final String REMEMBER = "REMEMBER";
    private static final String LOGIN = "LOGIN";
    private SharedPreferences mPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_login_one);

        edtEmail = (EditText) findViewById(R.id.editText_email);
        edtPassword = (EditText) findViewById(R.id.editText_password);
        cbRemember = (CheckBox) findViewById(R.id.checkbox_remember);

        mPLogin = new PLogin(this, new LoginService());

        Init();
    }

    @Override
    public void setupLogin(String email, String password, boolean remember){
        edtEmail.setText(email);
        edtPassword.setText(password);
        cbRemember.setChecked(remember);
    }

    @Override
    public void onClickLogin(View view){
        editSharePreference();
    }

    @Override
    public void startMainActivity(){
        startActivities(MainActivity.class, "Email", getUsername());
    }

    @Override
    public void startActivities(Class mClass, String intent_name,  String intent_content){
        Intent mIntent = new Intent(this, mClass);
        mIntent.putExtra(intent_name, intent_content);
        startActivity(mIntent);
    }

    @Override
    public String getUsername() {
        return this.edtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return this.edtPassword.getText().toString();
    }

    @Override
    public boolean getLoginStatus() {
        return true;
    }

    @Override
    public boolean getRemember() {
        return this.cbRemember.isChecked();
    }

    @Override
    public void showUsernameError(int resId) {
        edtEmail.setError(getString(resId));
    }

    @Override
    public void showPasswordError(int resId) {
        edtPassword.setError(getString(resId));
    }

    @Override
    public void Init() {
        MUserLogin mUserLogin = null;
        mPreferences = getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
        boolean loginStatus = mPreferences.getBoolean(LOGIN, false);
        if (loginStatus){
            startActivities(MainActivity.class, "Username", mPreferences.getString(EMAIL, "").toString());
        }else {
            boolean remember = false;
            //   boolean remember = mPreferences.getBoolean(REMEMBER, false);
            if (remember) {
                mUserLogin = new MUserLogin(mPreferences.getString(EMAIL, "").toString(),
                        mPreferences.getString(PASSWORD, "").toString(),
                        remember);
            } else
                mUserLogin = new MUserLogin("", "", false);
            setupLogin(mUserLogin.getEmail(), mUserLogin.getPassword(), mUserLogin.isRemember());
        }
    }

    @Override
    public void editSharePreference(){
        SharedPreferences.Editor e = mPreferences.edit();
        e.putString(EMAIL, getUsername());
        e.putString(PASSWORD, getPassword());
        e.putBoolean(REMEMBER, getRemember());
        e.putBoolean(LOGIN, getLoginStatus());
        e.commit();
        mPLogin.loginClick();
    }

    @Override
    public void showToast() {
        Toast.makeText(VLogin.this, "Something is wrong!", Toast.LENGTH_SHORT).show();
    }
}