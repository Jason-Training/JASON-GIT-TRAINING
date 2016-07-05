package com.example.jason.opps_concept.Model;

/**
 * Created by jason on 05/07/2016.
 */
public class PM extends Staff {


    public PM(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public float getPayroll() {
        return (float) 2.5 * 5000000;
    }
}
