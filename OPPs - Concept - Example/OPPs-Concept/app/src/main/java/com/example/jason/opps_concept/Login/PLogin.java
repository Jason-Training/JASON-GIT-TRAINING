package com.example.jason.opps_concept.Login;
import com.example.jason.opps_concept.R;

/**
 * Created by jason on 01/07/2016.
 */
public class PLogin {

    private iLoginView mView;
    private LoginService loginService;

    public PLogin(iLoginView mView, LoginService loginService) {
        this.mView = mView;
        this.loginService = loginService;
    }

    public void loginClick() {
        String email = mView.getUsername();
        String password = mView.getPassword();
        if (email.isEmpty()) {
            mView.showUsernameError(R.string.username_Error);
            return;
        } else if (password.isEmpty()) {
            mView.showPasswordError(R.string.password_Error);
            return;
        } else {
            boolean checkLogin = loginService.checkLogin(email, password);
            if (checkLogin) {
                mView.startMainActivity();
                return;
            } else {
                mView.showLoginError();
                return;
            }
        }
    }

    public int Math(){
        return 2 + 2;
    }
}