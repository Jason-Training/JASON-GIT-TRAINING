package com.example.jason.androidintroductionexample.ContentProvider.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jason.androidintroductionexample.ContentProvider.Presenter.PAddStaff;
import com.example.jason.androidintroductionexample.R;

public class AddStaffActivity extends AppCompatActivity implements IAddStaffView{

    private EditText edtName = null, edtBirthDay = null, edtPhoneNumber = null;
    private PAddStaff mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        edtName = (EditText) findViewById(R.id.editText_name);
        edtBirthDay = (EditText) findViewById(R.id.editText_yearOfBirth);
        edtPhoneNumber = (EditText) findViewById(R.id.editText_phoneNumber);
        mPresenter = new PAddStaff(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void saveStaffInformation(View v) {
        mPresenter.checkEmpty();
    }

    @Override
    public String getStaffName() {
        return getEdtName().getText().toString();
    }

    @Override
    public String getStaffYearOfBirth() {
        return getEdtBirthDay().getText().toString();
    }

    @Override
    public String getStaffPhoneNumber() {
        return getEdtPhoneNumber().getText().toString();
    }

    @Override
    public void showEmptyName(int resID) {
        edtName.setError(getString(resID));
    }

    @Override
    public void showEmptyBirthDay(int resID) {
        edtBirthDay.setError(getString(resID));
    }

    @Override
    public void showEmptyPhoneNumber(int resID) {
        edtPhoneNumber.setError(getString(resID));
    }

    @Override
    public EditText getEdtPhoneNumber() {
        return this.edtPhoneNumber;
    }

    @Override
    public EditText getEdtBirthDay() {
        return this.edtBirthDay;
    }

    @Override
    public EditText getEdtName() {
        return this.edtName;
    }
}
