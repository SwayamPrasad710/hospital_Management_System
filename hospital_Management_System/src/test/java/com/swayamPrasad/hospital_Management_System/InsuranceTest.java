package com.swayamPrasad.hospital_Management_System;

import com.swayamPrasad.hospital_Management_System.entity.Insurance;
import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.repository.InsuranceRepository;
import com.swayamPrasad.hospital_Management_System.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void insuranceTest(){
        Insurance insurance = Insurance.builder()
                .policyNumber("ICICI_8989")
                .provider("ICICI")
                .validUntil(LocalDate.of(2035, 9, 19))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(patient);

        var cancledInsurancePatient = insuranceService.cancleInsuranceFromPatient(patient.getId());

        System.out.println(cancledInsurancePatient);
    }
}
