package com.example.jason.opps_concept.Login;
import com.example.jason.opps_concept.OPPsConcept.View.MainActivity;
import com.example.jason.opps_concept.R;

/**
 * Created by jason on 01/07/2016.
 */
public class PLogin {

    private iLoginView mView;

    public PLogin(iLoginView mView) {
        this.mView = mView;
    }

    public void checkLogin(){
        String email = mView.getUsername();
        String password = mView.getPassword();
        if (email.isEmpty() && password.isEmpty()){
            mView.showUsernameError(R.string.username_Error);
            mView.showPasswordError(R.string.password_Error);
            return;
        } else if(email.isEmpty()){
            mView.showUsernameError(R.string.username_Error);
            return;
        }else if(password.isEmpty()){
            mView.showPasswordError(R.string.password_Error);
            return;
        }else {
            if (email.equals(email) && password.equals(password)) {
                mView.startActivities(MainActivity.class, "Email", email);
            } else mView.showToast();
        }
    }

}
