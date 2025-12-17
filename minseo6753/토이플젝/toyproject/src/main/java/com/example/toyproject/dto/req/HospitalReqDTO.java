package com.example.toyproject.dto.req;

public class HospitalReqDTO {

    public record RegisterDTO(
            String name,
            String address
    ){}
}
