package com.swayamPrasad.hospital_Management_System.repository;

import com.swayamPrasad.hospital_Management_System.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}