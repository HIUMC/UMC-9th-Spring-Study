package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    /**
     * Review 엔티티를 ReviewPreviewDTO로 변환하는 메서드
     *
     * @param review 변환할 Review 엔티티
     * @return 변환된 ReviewPreviewDTO
     */
    public static StoreResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName()) // Member 엔티티를 통해 닉네임 가져오기
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }

    /**
     * Page<Review>를 ReviewPreviewListDTO로 변환하는 메서드
     *
     * @param reviewPage 변환할 Page<Review> 객체
     * @return 변환된 ReviewPreviewListDTO
     */
    public static StoreResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewPage) {
        // 각 Review를 ReviewPreviewDTO로 변환
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewPage.getContent().stream()
                .map(StoreConverter::toReviewPreviewDTO).collect(Collectors.toList());

        // 페이징 정보와 함께 최종 DTO 생성
        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }
}
