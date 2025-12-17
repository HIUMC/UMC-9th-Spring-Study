package com.example.toyproject.service;

import com.example.toyproject.converter.PatientConverter;
import com.example.toyproject.domain.Patient;
import com.example.toyproject.dto.req.PatientReqDTO;
import com.example.toyproject.dto.res.PatientResDTO;
import com.example.toyproject.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientResDTO.RegisterDTO register(PatientReqDTO.RegisterDTO dto) {
        Patient patient = PatientConverter.toPatient(dto);
        patientRepository.save(patient);
        return PatientConverter.toRegisterDTO(patient);
    }
}
