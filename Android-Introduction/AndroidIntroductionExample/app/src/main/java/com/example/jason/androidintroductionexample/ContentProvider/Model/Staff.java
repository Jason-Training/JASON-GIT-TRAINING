package com.example.jason.androidintroductionexample.ContentProvider.Model;

/**
 * Created by jason on 08/07/2016.
 */
public class Staff {
    private String Name;
    private String YearOfBirth;
    private String Sex;
    private String PhoneNumber;

    public Staff(String name, String yearOfBirth, String sex, String phoneNumber) {
        Name = name;
        YearOfBirth = yearOfBirth;
        Sex = sex;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getYearOfBirth() {
        return YearOfBirth;
    }

    public String getSex() {
        return Sex;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
