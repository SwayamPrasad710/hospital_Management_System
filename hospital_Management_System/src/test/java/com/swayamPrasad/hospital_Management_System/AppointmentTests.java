package com.swayamPrasad.hospital_Management_System;

import com.swayamPrasad.hospital_Management_System.entity.Appointment;
import com.swayamPrasad.hospital_Management_System.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 12, 26, 11, 11, 0))
                .reason("Allergic reaction checkup.")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);

        var reAppointment = appointmentService.reAppointment(newAppointment.getId(), 3L);
        System.out.println(reAppointment);
    }
}
