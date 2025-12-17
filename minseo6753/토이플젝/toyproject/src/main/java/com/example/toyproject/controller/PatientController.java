package com.example.toyproject.controller;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.success.GeneralSuccessCode;
import com.example.toyproject.dto.req.PatientReqDTO;
import com.example.toyproject.dto.res.PatientResDTO;
import com.example.toyproject.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patients")
    public ApiResponse<PatientResDTO.RegisterDTO> register(
            @RequestBody PatientReqDTO.RegisterDTO dto
    ){
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, patientService.register(dto));
    }
}
