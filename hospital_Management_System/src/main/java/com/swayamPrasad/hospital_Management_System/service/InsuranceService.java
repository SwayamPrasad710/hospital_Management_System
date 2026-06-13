package com.swayamPrasad.hospital_Management_System.service;

import com.swayamPrasad.hospital_Management_System.entity.Insurance;
import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.repository.InsuranceRepository;
import com.swayamPrasad.hospital_Management_System.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                        () -> new EntityNotFoundException("Patient nto found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bi-directional mapping

        return patient;
    }

    @Transactional
    public Patient cancleInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient don't exists with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }
}
