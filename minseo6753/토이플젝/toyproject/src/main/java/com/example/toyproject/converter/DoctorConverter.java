package com.example.toyproject.converter;

import com.example.toyproject.domain.Doctor;
import com.example.toyproject.dto.req.DoctorReqDTO;
import com.example.toyproject.dto.res.DoctorResDTO;

public class DoctorConverter {

    public static Doctor toDoctor(DoctorReqDTO.RegisterDTO dto){
        return Doctor.builder()
                .name(dto.name())
                .build();
    }

    public static DoctorResDTO.RegisterDTO toResponseDTO(Doctor doctor){
        return DoctorResDTO.RegisterDTO.builder()
                .id(doctor.getId())
                .build();
    }
}
