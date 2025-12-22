package com.example.Chapter6.domain.user.dto.request;

import com.example.Chapter6.domain.user.enums.Gender;
import com.example.Chapter6.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            @NotBlank
            String name,
            @NotNull
            Gender gender,
            LocalDate birth,
            String email,
            String password,
            String phoneNum,
            @ExistFoods
            List<Long> preferCategory

    ){}

    public record AddMissionDTO(
            Long missionId,
            Long memberId
    ){}

    // 로그인
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}

    public record LogoutDTO(
            @NotBlank
            String token
    ){}
}
