package com.example.toyproject.service;

import com.example.toyproject.apiPayLoad.code.error.HospitalErrorCode;
import com.example.toyproject.apiPayLoad.exception.HospitalException;
import com.example.toyproject.converter.DepartmentConverter;
import com.example.toyproject.domain.Department;
import com.example.toyproject.domain.Hospital;
import com.example.toyproject.dto.req.DepartmentReqDTO;
import com.example.toyproject.dto.res.DepartmentResDTO;
import com.example.toyproject.repository.DepartmentRepository;
import com.example.toyproject.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final HospitalRepository hospitalRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResDTO.RegisterDTO register(Long hospitalId, DepartmentReqDTO.RegisterDTO dto) {

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new HospitalException(HospitalErrorCode.NOT_FOUND));

        Department department = DepartmentConverter.toDepartment(dto, hospital);

        departmentRepository.save(department);

        return DepartmentConverter.toRegisterDTO(department);
    }
}
