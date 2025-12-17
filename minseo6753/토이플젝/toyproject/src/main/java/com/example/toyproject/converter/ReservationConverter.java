package com.example.toyproject.converter;

import com.example.toyproject.domain.Doctor;
import com.example.toyproject.domain.Patient;
import com.example.toyproject.domain.Reservation;
import com.example.toyproject.dto.req.ReservationReqDTO;
import com.example.toyproject.dto.res.ReservationResDTO;

public class ReservationConverter {

    public static Reservation toReservation(
            ReservationReqDTO.RegisterDTO dto,
            Patient patient,
            Doctor doctor
    ){
        return Reservation.builder()
                .patient(patient)
                .doctor(doctor)
                .time(dto.time())
                .build();
    }

    public static ReservationResDTO.RegisterDTO toRegisterDTO(
            Reservation reservation
    ){
        return ReservationResDTO.RegisterDTO.builder()
                .id(reservation.getId())
                .build();
    }
}
