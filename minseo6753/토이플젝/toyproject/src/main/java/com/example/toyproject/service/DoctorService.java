package com.example.toyproject.service;

import com.example.toyproject.dto.req.DoctorReqDTO;
import com.example.toyproject.dto.res.DoctorResDTO;

public interface DoctorService {
    DoctorResDTO.RegisterDTO register(DoctorReqDTO.RegisterDTO dto);

    DoctorResDTO.RegisterDTO updateDepartment(Long doctorId, DoctorReqDTO.UpdateDepartmentDTO dto);
}
