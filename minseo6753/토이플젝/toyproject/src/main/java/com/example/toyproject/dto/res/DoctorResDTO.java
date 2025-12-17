package com.example.toyproject.dto.res;

import lombok.Builder;

public class DoctorResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ){}
}
