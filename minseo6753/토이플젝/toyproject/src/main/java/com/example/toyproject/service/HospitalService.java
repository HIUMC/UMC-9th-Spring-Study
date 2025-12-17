package com.example.toyproject.service;

import com.example.toyproject.dto.req.HospitalReqDTO;
import com.example.toyproject.dto.res.HospitalResDTO;

public interface HospitalService {
    public HospitalResDTO.RegisterDTO register(HospitalReqDTO.RegisterDTO dto);
}
