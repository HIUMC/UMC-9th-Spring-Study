package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.util.List;

public class ReviewConverter {

    public static ReviewResDto.ReviewDetailDto toReviewResDetailDto(Review review) {
        return ReviewResDto.ReviewDetailDto.builder()
                .id(review.getId())
                .star(review.getStar())
                .content(review.getContent())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .build();
    }

    // result -> DTO
    public static ReviewResDto.ReviewPreViewListDto toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDto.ReviewPreViewListDto.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDto.ReviewPreViewDto toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDto.ReviewPreViewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStar())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }

    public static Page<ReviewResDto.MyReviewSummaryDto> toMyReviewSummaryPage(Page<Review> reviewPage) {
        List<ReviewResDto.MyReviewSummaryDto> content = reviewPage.getContent()
                .stream()
                .map(review -> ReviewResDto.MyReviewSummaryDto.builder()
                        .id(review.getId())
                        .content(review.getContent())
                        .star(review.getStar())
                        .storeName(review.getStore().getName())
                        .build()
                )
                .toList(); // Stream 사용

        return new PageImpl<>(
                content,
                reviewPage.getPageable(),
                reviewPage.getTotalElements()
        );
    }
}
