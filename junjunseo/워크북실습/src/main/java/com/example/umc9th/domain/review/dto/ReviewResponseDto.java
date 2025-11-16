package com.example.umc9th.domain.review.dto;

import com.example.umc9th.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ReviewResponseDto {
    private Long id;
    private String content;
    private Float star;
    private String storeName;
    private String memberName;
    private Long memberId;
    private Long storeId;

    public static ReviewResponseDto from(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .star(review.getStar())
                .content(review.getContent())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .build();
    }
}