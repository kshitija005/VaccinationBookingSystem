package com.example.VacciNation.service;

import com.example.VacciNation.Enum.Gender;
import com.example.VacciNation.dto.request.PatientRequest;
import com.example.VacciNation.dto.responce.PatientResponce;
import com.example.VacciNation.excepction.PatientNotFoundException;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    PatientRepository patientRepository;

    public PatientResponce getPatient(int id){
        Optional<Patient> patientOptional= patientRepository.findById(id);

        if(patientOptional.isEmpty())
        {
            throw new PatientNotFoundException("Invalid Patient id");
        }
        Patient patient = patientOptional.get();
        PatientResponce patientResponce = new PatientResponce();
        patientResponce.setName(patient.getName());
        patientResponce.setVaccinated(patient.isVaccinated());
        patientResponce.setEmailId(patient.getEmailId());
        return patientResponce;
    }

    public PatientResponce addPatient(PatientRequest patientRequest)
    {
        // 1. request dto -> model/ entity
        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setName(patientRequest.getName());
        patient.setAge(patientRequest.getAge());
        patient.setEmailId(patientRequest.getEmailId());
        patient.setGender(patientRequest.getGender());


        Patient savedPatient = patientRepository.save(patient); // returns saved patient

        //convert model -> response dto
        PatientResponce patientResponce = new PatientResponce();
        patientResponce.setName(patientResponce.getName());
        patientResponce.setVaccinated(patientResponce.isVaccinated());
        patientResponce.setEmailId(patientResponce.getEmailId());

        return patientResponce;

    }

    public List<PatientResponce> getAllPatientsByGender(Gender gender) {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponce> patientResponces = new ArrayList<>();
        for (Patient patient: patients) {
            if (patient.getGender() == gender) {
                PatientResponce patientResponce = new PatientResponce();
                patientResponce.setName(patientResponce.getName());
                patientResponce.setVaccinated(patientResponce.isVaccinated());
                patientResponce.setEmailId(patientResponce.getEmailId());

                patientResponces.add(patientResponce);
            }
        }


        return patientResponces;
    }

}
