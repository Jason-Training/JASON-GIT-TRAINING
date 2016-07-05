package com.example.jason.opps_concept.Model;

/**
 * Created by jason on 04/07/2016.
 */
public class Def extends Staff implements iPayroll {

    public Def(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public float Payroll() {
        return (float) 1.2 * 5000000;
    }

    @Override
    public float getPayroll() {
        return (float) 1.2 * 5000000;
    }
}
