package com.example.VacciNation.controller;

import com.example.VacciNation.Enum.VaccinationBrand;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController
{
    @Autowired
    DoseService doseService;


    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientId,
                   @RequestParam("brand")VaccinationBrand vaccinationBrand)
    {
        return doseService.addDose(patientId, vaccinationBrand);
    }


}
