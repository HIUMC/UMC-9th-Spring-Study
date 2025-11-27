package hello.umc9th.domain.member.dto;

import hello.umc9th.domain.member.enums.Gender;
import hello.umc9th.global.annotation.ExistFoods;

import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            String name,
            Gender gender,
            String address,

            @ExistFoods
            List<Long> preferCategory //멤버 엔터티에는 없지만 MemberFood 클래스에 넣을것 -> 서비스코드에서 해결
    ){}
}
