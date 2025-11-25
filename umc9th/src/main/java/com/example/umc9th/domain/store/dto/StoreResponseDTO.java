package com.example.umc9th.domain.store.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreResponseDTO {

    /**
     * 가게의 리뷰 목록과 페이징 정보를 담는 DTO
     */
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO {
        List<ReviewPreviewDTO> reviewList; // 리뷰 목록
        Integer listSize; // 현재 페이지의 리뷰 수
        Integer totalPage; // 전체 페이지 수
        Long totalElements; // 전체 리뷰 수
        Boolean isFirst; // 첫 페이지 여부
        Boolean isLast; // 마지막 페이지 여부
    }

    /**
     * 각 리뷰의 상세 정보를 담는 DTO
     * record를 사용하여 불변(immutable) 데이터를 간결하게 표현합니다.
     * - record는 final 필드와 getter, equals(), hashCode(), toString() 메서드를 자동으로 생성해줍니다.
     */
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        String ownerNickname; // 리뷰 작성자 닉네임
        Float score; // 리뷰 별점
        String body; // 리뷰 내용
        LocalDate createdAt; // 리뷰 작성일
    }
}
