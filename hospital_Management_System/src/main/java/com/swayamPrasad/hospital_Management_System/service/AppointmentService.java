package com.swayamPrasad.hospital_Management_System.service;

import com.swayamPrasad.hospital_Management_System.entity.Appointment;
import com.swayamPrasad.hospital_Management_System.entity.Doctor;
import com.swayamPrasad.hospital_Management_System.entity.Patient;
import com.swayamPrasad.hospital_Management_System.repository.AppointmentRepository;
import com.swayamPrasad.hospital_Management_System.repository.DoctorRepository;
import com.swayamPrasad.hospital_Management_System.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long Id){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(Id).orElseThrow();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment); // maintain bidirectional consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAppointment(Long appointmentId, Long doctorId){
        Doctor newDoctor =  doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        appointment.setDoctor(newDoctor);
        newDoctor.getAppointments().add(appointment);

        return appointment;
    }
}
