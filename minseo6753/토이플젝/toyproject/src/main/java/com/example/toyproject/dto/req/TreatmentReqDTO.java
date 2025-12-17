package com.example.toyproject.dto.req;

public class TreatmentReqDTO {

    public record RegisterDTO(
            Long reservationId,
            Integer fee
    ){}
}
