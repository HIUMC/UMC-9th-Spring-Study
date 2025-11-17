package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.common.annotation.ExistFoods;
import lombok.Getter;

import java.util.List;

/**
 * 회원가입 요청을 처리하기 위한 DTO (Data Transfer Object) 입니다.
 * 클라이언트로부터 전달받은 사용자 정보를 담는 역할을 합니다.
 */
@Getter
public class MemberRequestDTO {

    /**
     * 사용자 이름
     */
    private String name;

    /**
     * 사용자 성별
     * "MALE", "FEMALE" 과 같은 문자열로 받습니다.
     */
    private String gender;

    /**
     * 생년 (Year)
     */
    private Integer birthYear;

    /**
     * 생월 (Month)
     */
    private Integer birthMonth;

    /**
     * 생일 (Day)
     */
    private Integer birthDay;

    /**
     * 주소
     */
    private String address;

    /**
     * 상세 주소
     */
    private String detailAddress;

    /**
     * 선호하는 음식 카테고리 ID 목록
     * 사용자가 선택한 음식들의 ID를 리스트 형태로 받습니다.
     */
    @ExistFoods
    private List<Long> preferFood;
}
