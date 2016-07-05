package com.example.jason.opps_concept.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jason.opps_concept.CustomizeExceptionHandling.NullValue;
import com.example.jason.opps_concept.CustomizeExceptionHandling.NullValueException;
import com.example.jason.opps_concept.Presenter.pCheckSalary;
import com.example.jason.opps_concept.R;

import java.util.ArrayList;
import java.util.List;

public class CheckSalaryActivity extends AppCompatActivity implements iCheckSalary{

    private EditText edtName, edtAge;
    private Spinner spnSex, spnPosition;
    private String Name = null, Sex = null, Position = null, Age = null;
    private pCheckSalary mCheckSalary;
    private NullValue mNullValueName;
    private NullValue mNullValueAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_salary);

        mCheckSalary = new pCheckSalary(this);

        //EditText call view item
        edtName = (EditText) findViewById(R.id.editText_staff_name);
        edtAge = (EditText) findViewById(R.id.editText_staff_age);
        //Spinner call view item
        spnSex = (Spinner) findViewById(R.id.spinner_staff_sex);
        spnPosition = (Spinner) findViewById(R.id.spinner_staff_position);
        //Setup spinner data
        setSpinner(spnSex, setListSex());
        setSpinner(spnPosition, setListPosition());

        //Set spinner onItemSelectClick()
        spnSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Sex = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Set spinner onItemSelectClick()
        spnPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Position = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //on click event
    @Override
    public void onclickCheckSalary(View v){
        Name = edtName.getText().toString();
        Age = edtAge.getText().toString();
        mNullValueName = new NullValue(Name);
        mNullValueAge = new NullValue(Age);
        try {
            mNullValueName.checkValue();
            mNullValueAge.checkValue();
            mCheckSalary.setStaffInformation(Name, Sex, Age, Position);
        } catch (NullValueException e) {
            e.printStackTrace();
            Toast.makeText(CheckSalaryActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //Set up Spinner
    @Override
    public void setSpinner(Spinner spinner, List<String> list) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    //Set list sex
    @Override
    public List<String> setListSex(){
        List<String> list = new ArrayList<>();
        list.add("Male");
        list.add("Female");
        return list;
    }

    //Set list position
    @Override
    public List<String> setListPosition(){
        List<String> list = new ArrayList<>();
        list.add("Def");
        list.add("Leader");
        list.add("PM");
        list.add("CEO");
        return list;
    }

}

