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

    public String getPassword() {
        return password;
    }

    public boolean isRemember() {
        return remember;
    }


}
