package com.example.jason.opps_concept.Login;

/**
 * Created by jason on 01/07/2016.
 */
public class MUserLogin {
    public String Email;
    public String password;
    public boolean remember;

    public MUserLogin(String email, String password, boolean remember) {
        Email = email;
        this.password = password;
        this.remember = remember;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

}
