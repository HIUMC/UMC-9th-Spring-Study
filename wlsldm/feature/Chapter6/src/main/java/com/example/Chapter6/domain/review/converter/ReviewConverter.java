package com.example.Chapter6.domain.review.converter;

import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.user.entity.Member;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.reviewDTO dto,
                                  Store store, Member member) {
        return Review.builder()
                .store(store)
                .member(member)
                .content(dto.content())
                .stars(dto.stars())
                .build();
    }

    // result -> DTO
    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
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

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStars())
                .body(review.getContent())
                .createAt(LocalDate.from(review.getCreateAt()))
                .build();
    }
}
