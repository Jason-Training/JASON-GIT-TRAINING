package com.example.jason.opps_concept.OPPsConcept.View;

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
import com.example.jason.opps_concept.OPPsConcept.Presenter.pCheckSalary;
import com.example.jason.opps_concept.R;

import java.util.ArrayList;
import java.util.List;

public class CheckSalaryActivity extends AppCompatActivity implements iCheckSalary{

    private EditText edtName, edtAge;
    private Spinner spnSex, spnPosition;
    private String Sex = null, Position = null;
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
        mNullValueName = new NullValue(getName());
        mNullValueAge = new NullValue(getAge());
        try {
            mNullValueName.checkValue();
            mNullValueAge.checkValue();
            mCheckSalary.setStaffInformation();
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

    @Override
    public String getSex() {
        return this.Sex;
    }

    @Override
    public String getName() {
        return edtName.getText().toString();
    }

    @Override
    public String getAge() {
        return edtAge.getText().toString();
    }

    @Override
    public String getPosition() {
        return this.Position;
    }

    @Override
    public void showCheckAge(Exception e) {
        Toast.makeText(getApplicationContext(), "You are " + e.getMessage() + " to work on my company!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCheckSalary(float payroll) {
        Toast.makeText(getApplicationContext(), "Your salary: " + payroll, Toast.LENGTH_LONG).show();
    }
}

