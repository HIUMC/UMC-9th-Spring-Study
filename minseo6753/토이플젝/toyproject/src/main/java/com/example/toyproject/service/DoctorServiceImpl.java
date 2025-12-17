package com.example.toyproject.service;

import com.example.toyproject.converter.DoctorConverter;
import com.example.toyproject.domain.Doctor;
import com.example.toyproject.dto.req.DoctorReqDTO;
import com.example.toyproject.dto.res.DoctorResDTO;
import com.example.toyproject.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public DoctorResDTO.RegisterDTO register(DoctorReqDTO.RegisterDTO dto) {
        Doctor doctor = DoctorConverter.toDoctor(dto);
        doctorRepository.save(doctor);
        return DoctorConverter.toRegisterDTO(doctor);
    }
}
