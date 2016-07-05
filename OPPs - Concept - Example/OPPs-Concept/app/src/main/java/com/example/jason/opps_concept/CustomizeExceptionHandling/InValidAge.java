package com.example.jason.opps_concept.CustomizeExceptionHandling;

/**
 * Created by jason on 05/07/2016.
 */
public class InValidAge {
    private int Number;

    public InValidAge(int number) {
        Number = number;
    }

    public void checkValid() throws InvalidAgeException {
        if (Number < 22)
            throw new InvalidAgeException("too young");
        if (Number > 40) throw new InvalidAgeException("too old");
    }
}
