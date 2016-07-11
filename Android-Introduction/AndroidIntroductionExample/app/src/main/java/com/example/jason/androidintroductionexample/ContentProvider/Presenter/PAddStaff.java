package com.example.jason.androidintroductionexample.ContentProvider.Presenter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.jason.androidintroductionexample.ContentProvider.Providers.StaffProvider;
import com.example.jason.androidintroductionexample.ContentProvider.View.AddStaffActivity;
import com.example.jason.androidintroductionexample.ContentProvider.View.IAddStaffView;
import com.example.jason.androidintroductionexample.R;

/**
 * Created by jason on 11/07/2016.
 */
public class PAddStaff {
    private IAddStaffView mView;
    public PAddStaff(IAddStaffView mView) {
        this.mView = mView;
    }

    public void checkEmpty(){
        String name = mView.getStaffName();
        String yearOfBirth = mView.getStaffYearOfBirth();
        String phoneNumber = mView.getStaffPhoneNumber();
        boolean cancel = false;
        if (TextUtils.isEmpty(name)) {
            cancel = true;
        }
        if (TextUtils.isEmpty(yearOfBirth)) {
            cancel = true;
        }
        if (TextUtils.isEmpty(phoneNumber)) {
            cancel = true;
        }
        if (cancel) {
            Toast.makeText(mView.getContext(), "Something are empty!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mView.getContext(), "Hello", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveStaffInformation(){
        ContentValues values = new ContentValues();

        values.put(StaffProvider.NAME, mView.getStaffName());
        values.put(StaffProvider.YEAR_OF_BIRTH, mView.getStaffYearOfBirth());
        values.put(StaffProvider.PHONE_NUMBER, mView.getStaffPhoneNumber());

        Uri uri = mView.getContext().getContentResolver().insert(
                StaffProvider.CONTENT_URI, values);
    }
}
