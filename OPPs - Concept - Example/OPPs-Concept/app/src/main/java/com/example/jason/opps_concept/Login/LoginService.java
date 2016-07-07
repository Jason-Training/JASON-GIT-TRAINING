package com.example.jason.opps_concept.Login;

/**
 * Created by jason on 06/07/2016.
 */
public class LoginService {

    public LoginService(){}

    public boolean checkLogin(String email, String password){
        if (email.equals("jason") && password.equals("123")) {
            return true;
        } else return false;
    }
}
