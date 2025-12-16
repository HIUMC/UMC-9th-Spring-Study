package com.example.umcworkbook.dto.req;

import com.example.umcworkbook.annotation.ExistCategories;
import com.example.umcworkbook.entity.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {

    public record JoinDto(
            @NotBlank
            String name,
            @Email
            String email,
            @NotBlank
            String password,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            String address,
            @ExistCategories
            List<Long> categories
    ){}

    public record LoginDto(
            @NotBlank @Email
            String email,
            @NotBlank
            String password
    ){}
}
