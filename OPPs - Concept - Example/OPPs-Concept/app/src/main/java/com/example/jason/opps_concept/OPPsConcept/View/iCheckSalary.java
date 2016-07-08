package com.example.jason.opps_concept.OPPsConcept.View;

import android.view.View;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by jason on 04/07/2016.
 */
public interface iCheckSalary {
    void onclickCheckSalary(View v);
    void setSpinner(Spinner spinner, List<String> list);
    List<String> setListSex();
    List<String> setListPosition();
    String getName();
    String getAge();
    String getPosition();
    String getSex();
    void showCheckAge(Exception e);
    void showCheckSalary(float payroll);
}
