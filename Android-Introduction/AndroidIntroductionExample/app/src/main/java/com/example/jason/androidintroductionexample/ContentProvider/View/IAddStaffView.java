package com.example.jason.androidintroductionexample.ContentProvider.View;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

/**
 * Created by jason on 08/07/2016.
 */
public interface IAddStaffView {
    void saveStaffInformation(View v);
    String getStaffName();
    String getStaffYearOfBirth();
    String getStaffPhoneNumber();
    void showEmptyName(int resID);
    void showEmptyBirthDay(int resID);
    void showEmptyPhoneNumber(int resID);
    EditText getEdtName();
    EditText getEdtBirthDay();
    EditText getEdtPhoneNumber();
    Context getContext();
}
