package com.example.toyproject.converter;

import com.example.toyproject.domain.Hospital;
import com.example.toyproject.dto.req.HospitalReqDTO;
import com.example.toyproject.dto.res.HospitalResDTO;

public class HospitalConverter {

    public static HospitalResDTO.RegisterDTO toRegisterDTO(
            Hospital hospital
    ){
        return HospitalResDTO.RegisterDTO.builder()
                .id(hospital.getId())
                .build();
    }

    public static Hospital toHospital(
            HospitalReqDTO.RegisterDTO dto
    ){
        return Hospital.builder()
                .name(dto.name())
                .address(dto.address())
                .build();
    }
}
