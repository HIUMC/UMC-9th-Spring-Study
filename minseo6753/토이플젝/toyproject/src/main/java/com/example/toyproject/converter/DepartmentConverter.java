package com.example.toyproject.converter;

import com.example.toyproject.domain.Department;
import com.example.toyproject.domain.Hospital;
import com.example.toyproject.dto.req.DepartmentReqDTO;
import com.example.toyproject.dto.res.DepartmentResDTO;

public class DepartmentConverter {

    public static Department toDepartment(DepartmentReqDTO.RegisterDTO dto, Hospital hospital) {
        return Department.builder()
                .name(dto.name())
                .phoneNumber(dto.phoneNumber())
                .hospital(hospital)
                .build();
    }

    public static DepartmentResDTO.RegisterDTO toRegisterDTO(Department department) {
        return DepartmentResDTO.RegisterDTO.builder()
                .id(department.getId())
                .build();
    }
}
