package com.example.toyproject.converter;

import com.example.toyproject.domain.Reservation;
import com.example.toyproject.domain.Treatment;
import com.example.toyproject.dto.req.TreatmentReqDTO;
import com.example.toyproject.dto.res.TreatmentResDTO;

public class TreatmentConverter {

    public static Treatment toTreatment(
            TreatmentReqDTO.RegisterDTO dto,
            Reservation reservation
    ) {
        return Treatment.builder()
                .doctor(reservation.getDoctor())
                .patient(reservation.getPatient())
                .time(reservation.getTime())
                .fee(dto.fee())
                .build();
    }

    public static TreatmentResDTO.RegisterDTO toRegisterDTO(
            Treatment treatment
    ) {
        return TreatmentResDTO.RegisterDTO.builder()
                .id(treatment.getId())
                .build();
    }
}
