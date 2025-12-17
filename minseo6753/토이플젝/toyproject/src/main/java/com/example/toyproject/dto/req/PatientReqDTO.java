package com.example.toyproject.dto.req;

import com.example.toyproject.domain.Gender;

public class PatientReqDTO {

    public record RegisterDTO(
            String name,
            Integer age,
            Gender gender
    ){}
}
