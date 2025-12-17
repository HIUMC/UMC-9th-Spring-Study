package com.example.toyproject.converter;

import com.example.toyproject.domain.Patient;
import com.example.toyproject.dto.req.PatientReqDTO;
import com.example.toyproject.dto.res.PatientResDTO;

public class PatientConverter {

    public static PatientResDTO.RegisterDTO toRegisterDTO(
            Patient patient
    ){
        return PatientResDTO.RegisterDTO.builder()
                .id(patient.getId())
                .build();
    }

    public static Patient toPatient(
            PatientReqDTO.RegisterDTO dto
    ){
        return Patient.builder()
                .name(dto.name())
                .age(dto.age())
                .gender(dto.gender())
                .build();
    }
}
