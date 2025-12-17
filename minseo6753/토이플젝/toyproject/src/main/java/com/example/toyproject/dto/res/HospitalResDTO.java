package com.example.toyproject.dto.res;

import lombok.Builder;

public class HospitalResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ){}
}
