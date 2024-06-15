package com.example.VacciNation.controller;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.dto.request.PatientRequest;
import com.example.VacciNation.dto.responce.PatientResponce;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/patient")
public class PatientController
{
    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest)
    {
        try
            {
            PatientResponce patientResponce = patientService.addPatient((patientRequest));
            return new ResponseEntity<>(patientResponce, HttpStatus.CREATED);
            }
        catch (Exception e)
        {
            return new ResponseEntity<>("invalid request", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping("/get")
    public PatientResponce getPatient(@RequestParam("id") int id)
    {
        return patientService.getPatient(id);
    }


    @GetMapping("/get/gender/{gender}")
    public List<PatientResponce> getAllPatientsByGender(@PathVariable("gender") Gender gender)
    {
       return patientService.getAllPatientsByGender(gender);
    }
}
