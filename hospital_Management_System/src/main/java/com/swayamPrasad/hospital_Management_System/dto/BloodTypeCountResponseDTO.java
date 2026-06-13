package com.swayamPrasad.hospital_Management_System.dto;

import com.swayamPrasad.hospital_Management_System.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodTypeCountResponseDTO {
    private BloodGroupType bloodGroupType;
    private Long count;
}
