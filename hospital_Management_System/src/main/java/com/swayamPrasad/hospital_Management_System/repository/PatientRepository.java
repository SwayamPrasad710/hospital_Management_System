package com.swayamPrasad.hospital_Management_System.repository;

import com.swayamPrasad.hospital_Management_System.dto.BloodTypeCountResponseDTO;
import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    @Query("Select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);

//    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    @Query("select new com.swayamPrasad.hospital_Management_System.dto.BloodTypeCountResponseDTO(p.bloodGroup," + " Count(p)) from Patient p group by p.bloodGroup")
    List<BloodTypeCountResponseDTO> bloodGroupCount();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("Update Patient p SET p.name = :name where p.id = :id")
    int updatePatientNameById(@Param("name") String name, @Param("id") long id);

//    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();
}
