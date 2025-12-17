package com.example.toyproject.dto.res;

import lombok.Builder;

public class TreatmentResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ){}
}
