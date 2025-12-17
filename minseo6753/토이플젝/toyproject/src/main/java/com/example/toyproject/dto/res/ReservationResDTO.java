package com.example.toyproject.dto.res;

import lombok.Builder;

public class ReservationResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ){}
}
