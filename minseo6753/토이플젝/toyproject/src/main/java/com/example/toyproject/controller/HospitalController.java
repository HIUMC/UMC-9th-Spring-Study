package com.example.toyproject.controller;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.success.GeneralSuccessCode;
import com.example.toyproject.dto.req.DepartmentReqDTO;
import com.example.toyproject.dto.req.HospitalReqDTO;
import com.example.toyproject.dto.res.DepartmentResDTO;
import com.example.toyproject.dto.res.HospitalResDTO;
import com.example.toyproject.service.DepartmentService;
import com.example.toyproject.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final DepartmentService departmentService;

    @PostMapping("/hospitals")
    public ApiResponse<HospitalResDTO.RegisterDTO> register(
            @RequestBody HospitalReqDTO.RegisterDTO dto
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, hospitalService.register(dto));
    }

    @PostMapping("/hospitals/{hospitalId}/departments")
    public ApiResponse<DepartmentResDTO.RegisterDTO> register(
            @PathVariable("hospitalId") Long hospitalId,
            @RequestBody DepartmentReqDTO.RegisterDTO dto
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, departmentService.register(hospitalId, dto));
    }

}
