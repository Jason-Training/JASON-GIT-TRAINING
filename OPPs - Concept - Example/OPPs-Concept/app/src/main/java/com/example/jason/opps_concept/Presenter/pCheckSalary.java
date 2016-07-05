package com.example.jason.opps_concept.Presenter;

import android.widget.Toast;

import com.example.jason.opps_concept.CustomizeExceptionHandling.InValidAge;
import com.example.jason.opps_concept.CustomizeExceptionHandling.InvalidAgeException;
import com.example.jason.opps_concept.Model.Def;
import com.example.jason.opps_concept.Model.PM;
import com.example.jason.opps_concept.Model.Staff;
import com.example.jason.opps_concept.View.CheckSalaryActivity;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by jason on 04/07/2016.
 */
public class pCheckSalary {

    private InValidAge mInValidAge;
    private CheckSalaryActivity mView;

    public pCheckSalary(CheckSalaryActivity mView) {
        this.mView = mView;
    }

    public void setStaffInformation(String name, String sex, String age, String position){

        final Staff mStaff;
        int iAge = Integer.parseInt(age);
        mInValidAge = new InValidAge(iAge);
        try {
            mInValidAge.checkValid();
            switch (position){
                case "Def" : mStaff = new Def(name, sex, iAge);
                    saveStaff(mStaff);
                    break;
                case "PM" : mStaff = new PM(name, sex, iAge);
                    saveStaff(mStaff);
                    break;
            }
        } catch (InvalidAgeException e) {
            e.printStackTrace();
            Toast.makeText(mView, "You are " + e.getMessage() + " to work on my company!", Toast.LENGTH_LONG).show();
        }
    }

    public void saveStaff(Staff staff){
            Toast.makeText(mView, "Your salary: " + staff.getPayroll(), Toast.LENGTH_LONG).show();
    }
}
