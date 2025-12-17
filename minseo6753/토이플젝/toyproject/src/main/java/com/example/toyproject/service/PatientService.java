package com.example.toyproject.service;

import com.example.toyproject.dto.req.PatientReqDTO;
import com.example.toyproject.dto.res.PatientResDTO;

public interface PatientService {
    public PatientResDTO.RegisterDTO register(PatientReqDTO.RegisterDTO dto);
}
