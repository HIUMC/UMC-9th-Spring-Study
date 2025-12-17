package com.example.toyproject.controller;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.success.GeneralSuccessCode;
import com.example.toyproject.dto.req.ReservationReqDTO;
import com.example.toyproject.dto.res.ReservationResDTO;
import com.example.toyproject.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PatchMapping("/reservations")
    public ApiResponse<ReservationResDTO.RegisterDTO> registerReservation(
            @RequestBody ReservationReqDTO.RegisterDTO dto
    ){
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reservationService.register(dto));
    }
}
