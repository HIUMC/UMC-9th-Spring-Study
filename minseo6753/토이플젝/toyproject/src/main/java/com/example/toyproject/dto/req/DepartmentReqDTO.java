package com.example.toyproject.dto.req;

public class DepartmentReqDTO {

    public record RegisterDTO(
            String name,
            String phoneNumber
    ){}
}
