package com.swayamPrasad.hospital_Management_System.repository;

import com.swayamPrasad.hospital_Management_System.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}