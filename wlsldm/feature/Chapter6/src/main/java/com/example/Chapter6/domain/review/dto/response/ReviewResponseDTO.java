package com.example.Chapter6.domain.review.dto.response;

import com.example.Chapter6.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {

    private Long id;
    private String content;
    private float stars;
    private String storeName;
    private String regionName;

    public static ReviewResponseDTO from(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .stars(review.getStars())
                .storeName(review.getStore().getName())
                .regionName(review.getStore().getRegion().getName())
                .build();
    }

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createAt
    ){}
}
