package hello.umc9th.domain.member.dto;

import hello.umc9th.domain.member.enums.Gender;
import hello.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            //워크북을 따라서 애노테이션 추가함.
            @NotBlank
            String name,
            @Email
            String email,
            @NotBlank
            String password,

            Gender gender,
            String address,

            @ExistFoods
            List<Long> preferCategory //멤버 엔터티에는 없지만 MemberFood 클래스에 넣을것 -> 서비스코드에서 해결
    ){}

    // 로그인
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
}
