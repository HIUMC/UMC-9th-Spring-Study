package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.common.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

/**
 * 회원가입 요청을 처리하기 위한 DTO (Data Transfer Object) 입니다.
 * 클라이언트로부터 전달받은 사용자 정보를 담는 역할을 합니다.
 */
@Getter
public class MemberRequestDTO {

    public record JoinDTO(
            @NotBlank(message = "이름은 필수 입력 값입니다.")
            String name,

            @NotBlank(message = "이메일은 필수 입력 값입니다.")
            @Email(message = "이메일 형식에 맞지 않습니다.")
            String email,

            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password,

            String gender,
            Integer birthYear,
            Integer birthMonth,
            Integer birthDay,
            String address,
            String detailAddress,

            /**
             * 선호하는 음식 카테고리 ID 목록
             * 사용자가 선택한 음식들의 ID를 리스트 형태로 받습니다.
             */
            @ExistFoods
            List<Long> preferFood
    ) {}

    // 로그인
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
}
