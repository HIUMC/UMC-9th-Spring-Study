package com.example.toyproject.service;

import com.example.toyproject.dto.req.TreatmentReqDTO;
import com.example.toyproject.dto.res.TreatmentResDTO;

public interface TreatmentService {
    TreatmentResDTO.RegisterDTO register(TreatmentReqDTO.RegisterDTO dto);
}
