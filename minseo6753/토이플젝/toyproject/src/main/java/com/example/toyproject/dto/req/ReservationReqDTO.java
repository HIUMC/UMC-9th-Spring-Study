package com.example.toyproject.dto.req;

import java.time.LocalDateTime;

public class ReservationReqDTO {

    public record RegisterDTO(
            Long patientId,
            Long doctorId,
            LocalDateTime time
    ){}
}
