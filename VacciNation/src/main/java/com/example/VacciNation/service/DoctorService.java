package com.example.VacciNation.service;

import com.example.VacciNation.excepction.DoctorNotFoundException;
import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService
{
    @Autowired
    DoctorRepository doctorRepository;


    public String addDoctor(Doctor doctor)
    {
        doctorRepository.save(doctor);
        return "Doctor saved successfully!!";
    }

    public Doctor getDoctor(int id)
    {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if(doctorOptional.isEmpty())
        {
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }
        Doctor doctor = doctorOptional.get();
        return doctor;
    }

    public String deleteDoctor(int id)
    {
        doctorRepository.deleteById(id);
        return "Doctor deleted successfully";
    }
}


