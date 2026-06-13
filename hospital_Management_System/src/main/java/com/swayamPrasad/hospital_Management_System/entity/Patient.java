package com.swayamPrasad.hospital_Management_System.entity;

import com.swayamPrasad.hospital_Management_System.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
//@Builder
@Table(
        name = "patient",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_and_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    private String gender;

    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
