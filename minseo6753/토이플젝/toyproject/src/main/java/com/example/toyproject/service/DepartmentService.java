package com.example.toyproject.service;

import com.example.toyproject.dto.req.DepartmentReqDTO;
import com.example.toyproject.dto.res.DepartmentResDTO;

public interface DepartmentService {
    DepartmentResDTO.RegisterDTO register(Long hospitalId, DepartmentReqDTO.RegisterDTO dto);
}
