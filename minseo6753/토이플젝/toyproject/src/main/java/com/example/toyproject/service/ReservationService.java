package com.example.toyproject.service;

import com.example.toyproject.dto.req.ReservationReqDTO;
import com.example.toyproject.dto.res.ReservationResDTO;

public interface ReservationService {
    ReservationResDTO.RegisterDTO register(ReservationReqDTO.RegisterDTO dto);
}
