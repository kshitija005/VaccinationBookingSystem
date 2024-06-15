package com.example.VacciNation.controller;

import com.example.VacciNation.dto.responce.AppointmentResponce;
import com.example.VacciNation.model.Appointment;
import com.example.VacciNation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")

public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookPatientAppointment(@RequestParam("pid") int patientId,
                                                      @RequestParam("did") int doctorId)
    {
        try {
            AppointmentResponce bookAppointment = appointmentService.bookAppointment(patientId, doctorId);
            return new ResponseEntity(bookAppointment,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
