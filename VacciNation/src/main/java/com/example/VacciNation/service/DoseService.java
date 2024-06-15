package com.example.VacciNation.service;

import com.example.VacciNation.Enum.VaccinationBrand;
import com.example.VacciNation.excepction.PatientNotFoundException;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.DoseRepository;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccinationBrand vaccinationBrand) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid Patient id");
        }

        Patient patient = patientOptional.get();


        if(patient.isVaccinated())
        {
            throw new RuntimeException();
        }

        patient.setVaccinated(true);

        Dose dose = new Dose();

        dose.setVaccineBrand(vaccinationBrand);

        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));

        dose.setPatient(patient); // setting the FK

        patientRepository.save(patient);
        return doseRepository.save(dose);


    }
}
