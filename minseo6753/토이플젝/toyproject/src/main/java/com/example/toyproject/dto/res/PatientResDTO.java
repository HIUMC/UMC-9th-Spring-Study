package com.example.toyproject.dto.res;

import lombok.Builder;

public class PatientResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ){}
}
