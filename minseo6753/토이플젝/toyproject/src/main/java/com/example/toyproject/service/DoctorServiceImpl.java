package com.example.toyproject.service;

import com.example.toyproject.apiPayLoad.code.error.DepartmentErrorCode;
import com.example.toyproject.apiPayLoad.code.error.DoctorErrorCode;
import com.example.toyproject.apiPayLoad.exception.DepartmentException;
import com.example.toyproject.apiPayLoad.exception.DoctorException;
import com.example.toyproject.converter.DoctorConverter;
import com.example.toyproject.domain.Department;
import com.example.toyproject.domain.Doctor;
import com.example.toyproject.dto.req.DoctorReqDTO;
import com.example.toyproject.dto.res.DoctorResDTO;
import com.example.toyproject.repository.DepartmentRepository;
import com.example.toyproject.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public DoctorResDTO.RegisterDTO register(DoctorReqDTO.RegisterDTO dto) {
        Doctor doctor = DoctorConverter.toDoctor(dto);
        doctorRepository.save(doctor);
        return DoctorConverter.toResponseDTO(doctor);
    }

    @Override
    public DoctorResDTO.RegisterDTO updateDepartment(Long doctorId, DoctorReqDTO.UpdateDepartmentDTO dto) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorException(DoctorErrorCode.NOT_FOUND));

        Department department = departmentRepository.findById(dto.departmentId())
                .orElseThrow(() -> new DepartmentException(DepartmentErrorCode.NOT_FOUND));

        Doctor updated = doctor.updateDepartment(department);
        return DoctorConverter.toResponseDTO(updated);
    }
}
