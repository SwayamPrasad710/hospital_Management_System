package com.swayamPrasad.hospital_Management_System.repository;

import com.swayamPrasad.hospital_Management_System.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}