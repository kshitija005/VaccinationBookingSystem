package com.example.VacciNation.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PatientResponce
{
    private String name;

    private boolean vaccinated;

    private String emailId;

}
