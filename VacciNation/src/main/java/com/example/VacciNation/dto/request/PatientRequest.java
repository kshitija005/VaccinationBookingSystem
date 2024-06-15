package com.example.VacciNation.dto.request;

import com.example.VacciNation.Enum.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PatientRequest
{
    private String name;

    private int age;

    private Gender gender;

    private String emailId;
}
