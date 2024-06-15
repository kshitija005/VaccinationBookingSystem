package com.example.VacciNation.service;

import com.example.VacciNation.Enum.AppointmentStatus;
import com.example.VacciNation.dto.responce.AppointmentResponce;
import com.example.VacciNation.dto.responce.PatientResponce;
import com.example.VacciNation.excepction.DoctorNotFoundException;
import com.example.VacciNation.excepction.PatientNotFoundException;
import com.example.VacciNation.model.Appointment;
import com.example.VacciNation.model.Doctor;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.AppointmentRepository;
import com.example.VacciNation.repository.DoctorRepository;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AppointmentService
{
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentResponce bookAppointment(int patientId, int doctorId)
    {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isEmpty())
        {
            throw new PatientNotFoundException("Invalid Patient Id");
        }

        Optional<Doctor> optionalDoctor= doctorRepository.findById(doctorId);
        if(optionalDoctor.isEmpty())
        {
            throw new DoctorNotFoundException("Invalid Doctor id");
        }

        Patient patient = optionalPatient.get();
        Doctor doctor = optionalDoctor.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setAppointmentStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment saveAppointment = appointmentRepository.save(appointment);

        //convet model to response dto

        AppointmentResponce appointmentResponce = new AppointmentResponce();
        appointmentResponce.setAppointmentId(saveAppointment.getAppointmentId());
        appointmentResponce.setAppointmentStatus(saveAppointment.getAppointmentStatus());
        appointmentResponce.setDateOfAppointment(saveAppointment.getDateOfAppointment());
        appointmentResponce.setDoctorName(saveAppointment.getDoctor().getName());

        Patient savedPatient = saveAppointment.getPatient();

        PatientResponce patientResponce = new PatientResponce(); //patient -> patient response
        patientResponce.setName(savedPatient.getName());  //setting attribute of patient response
        patientResponce.setEmailId(savedPatient.getEmailId());
        patientResponce.setVaccinated(savedPatient.isVaccinated());

        appointmentResponce.setPatientResponce(patientResponce); //setting patient response in appointment response

        return appointmentResponce;


    }
}
