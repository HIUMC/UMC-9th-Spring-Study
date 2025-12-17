package com.example.toyproject.service;

import com.example.toyproject.converter.HospitalConverter;
import com.example.toyproject.domain.Hospital;
import com.example.toyproject.dto.req.HospitalReqDTO;
import com.example.toyproject.dto.res.HospitalResDTO;
import com.example.toyproject.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public HospitalResDTO.RegisterDTO register(HospitalReqDTO.RegisterDTO dto) {
        Hospital hospital = HospitalConverter.toHospital(dto);
        hospitalRepository.save(hospital);
        return HospitalConverter.toRegisterDTO(hospital);
    }
}
