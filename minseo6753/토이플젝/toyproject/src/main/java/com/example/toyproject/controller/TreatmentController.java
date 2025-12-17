package com.example.toyproject.controller;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.success.GeneralSuccessCode;
import com.example.toyproject.dto.req.TreatmentReqDTO;
import com.example.toyproject.dto.res.TreatmentResDTO;
import com.example.toyproject.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;

    @PostMapping("/treatments")
    public ApiResponse<TreatmentResDTO.RegisterDTO> register(
            @RequestBody TreatmentReqDTO.RegisterDTO dto
    ){
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, treatmentService.register(dto));
    }
}
