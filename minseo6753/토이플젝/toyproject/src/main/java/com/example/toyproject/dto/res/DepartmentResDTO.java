package com.example.toyproject.dto.res;

import lombok.Builder;

public class DepartmentResDTO {

    @Builder
    public record RegisterDTO(
            Long id
    ) {}
}
