package com.example.jason.opps_concept.Login;

import android.view.View;

/**
 * Created by jason on 06/07/2016.
 */
public interface iLoginView {
    void customStartActivity(Class mClass);
    void startMainActivity();
    String getUsername();
    String getPassword();
    boolean getRemember();
    boolean getLoginStatus();
    void showUsernameError(int resId);
    void showPasswordError(int resId);
    void setupLogin(String username, String password, boolean remember);
    void onClickLogin(View v);
    void Init();
    void editSharePreference();
    void showLoginError();
}
