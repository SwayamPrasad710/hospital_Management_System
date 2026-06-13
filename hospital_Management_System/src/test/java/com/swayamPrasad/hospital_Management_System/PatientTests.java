package com.swayamPrasad.hospital_Management_System;

import com.swayamPrasad.hospital_Management_System.dto.BloodTypeCountResponseDTO;
import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.entity.type.BloodGroupType;
import com.swayamPrasad.hospital_Management_System.repository.PatientRepository;
import com.swayamPrasad.hospital_Management_System.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);

//        Patient patient = patientRepository.findByName("Kabir Singh");
//        System.out.println(patient);

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1992, 12, 1), "aarav.sharma@example.com");

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.AB_POSITIVE);
//
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Object[]> bloodGroupCount = patientRepository.countEachBloodGroupType();
//        for(Object[] bloodGroup: bloodGroupCount){
//            System.out.println(bloodGroup[0] + " : " +  bloodGroup[1]);
//        }

//        List<Patient> patientList = patientRepository.findAllPatient();
//        for (Patient patient : patientList){
//            System.out.println(patient);
//        }

//        int rowsUpdated = patientRepository.updatePatientNameById("Arav Sharma", 1L);
//        System.out.println("Total rows updated: " + rowsUpdated);

//        List<BloodTypeCountResponseDTO> bloodGroupList = patientRepository.bloodGroupCount();
//        for(BloodTypeCountResponseDTO bloodTypeCountResponseDTO: bloodGroupList){
//            System.out.println(bloodTypeCountResponseDTO);
//        }

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0, 3, Sort.by("name").descending()));
        for (Patient patient : patientList){
            System.out.println(patient);
        }
    }
}
