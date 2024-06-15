package com.example.VacciNation.dto.responce;

import com.example.VacciNation.Enum.AppointmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AppointmentResponce
{
    private String appointmentId;

    private Date dateOfAppointment;

    private AppointmentStatus appointmentStatus;

    private PatientResponce patientResponce;

    private String doctorName;
}
