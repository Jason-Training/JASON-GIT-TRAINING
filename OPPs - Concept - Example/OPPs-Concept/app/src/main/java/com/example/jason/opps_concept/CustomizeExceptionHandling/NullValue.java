package com.example.jason.opps_concept.CustomizeExceptionHandling;

/**
 * Created by jason on 05/07/2016.
 */
public class NullValue {
    private String Value;

    public NullValue(String value) {
        Value = value;
    }

    public void checkValue() throws NullValueException {
        if (Value.equals("")){
            throw new NullValueException("Something is empty!");
        }
    }
}
