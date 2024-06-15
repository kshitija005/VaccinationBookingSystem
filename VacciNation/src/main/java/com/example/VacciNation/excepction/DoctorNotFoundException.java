package com.example.VacciNation.excepction;

public class DoctorNotFoundException extends RuntimeException
{
    public DoctorNotFoundException(String message)
    {
        super(message);
    }
}
