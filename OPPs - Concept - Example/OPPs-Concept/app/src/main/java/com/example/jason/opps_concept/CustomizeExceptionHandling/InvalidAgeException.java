package com.example.jason.opps_concept.CustomizeExceptionHandling;

/**
 * Created by jason on 05/07/2016.
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message){
        super(message);
    }
}
