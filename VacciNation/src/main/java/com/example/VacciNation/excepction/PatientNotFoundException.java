package com.example.VacciNation.excepction;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message)
    {
        super(message);
    }
}
