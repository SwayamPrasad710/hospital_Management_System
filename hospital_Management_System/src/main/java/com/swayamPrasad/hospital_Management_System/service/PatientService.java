package com.swayamPrasad.hospital_Management_System.service;

import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

        return p1;
    }
}
