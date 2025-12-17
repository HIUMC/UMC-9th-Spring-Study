package com.example.toyproject.controller;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.success.GeneralSuccessCode;
import com.example.toyproject.dto.req.DoctorReqDTO;
import com.example.toyproject.dto.res.DoctorResDTO;
import com.example.toyproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/doctors")
    public ApiResponse<DoctorResDTO.RegisterDTO> register(
            @RequestBody DoctorReqDTO.RegisterDTO dto
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, doctorService.register(dto));
    }

    @PatchMapping("/doctors/{doctorId}/departments")
    public ApiResponse<DoctorResDTO.RegisterDTO> updateDepartment(
            @PathVariable Long doctorId,
            @RequestBody DoctorReqDTO.UpdateDepartmentDTO dto
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, doctorService.updateDepartment(doctorId, dto));
    }
}
