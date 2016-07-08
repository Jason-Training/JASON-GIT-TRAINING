package com.example.jason.opps_concept.OPPsConcept.Presenter;


import com.example.jason.opps_concept.CustomizeExceptionHandling.InValidAge;
import com.example.jason.opps_concept.CustomizeExceptionHandling.InvalidAgeException;
import com.example.jason.opps_concept.OPPsConcept.Model.Def;
import com.example.jason.opps_concept.OPPsConcept.Model.PM;
import com.example.jason.opps_concept.OPPsConcept.Model.Staff;
import com.example.jason.opps_concept.OPPsConcept.View.iCheckSalary;

/**
 * Created by jason on 04/07/2016.
 */
public class pCheckSalary {

    private InValidAge mInValidAge;
    private iCheckSalary mView;

    public pCheckSalary(iCheckSalary mView) {
        this.mView = mView;
    }

    public void setStaffInformation(){

        String name = mView.getName();
        String sex = mView.getSex();
        String age = mView.getAge();
        String position = mView.getPosition();

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
            mView.showCheckAge(e);
        }
    }

    public void saveStaff(Staff staff){
            mView.showCheckSalary(staff.getPayroll());
    }
}
