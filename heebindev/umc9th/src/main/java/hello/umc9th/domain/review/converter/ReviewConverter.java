package hello.umc9th.domain.review.converter;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.store.entity.Store;

public class ReviewConverter {

    //조회용
    public static ReviewResDTO.ReviewInfo toReviewInfo(Review review) {
        return ReviewResDTO.ReviewInfo.builder()
                .id(review.getId())
                .reviewContent(review.getReviewContent())
                .reviewScore(review.getReviewScore().name())
                .storeName(review.getStore().getName())
                .location(review.getStore().getLocation().getStoreLocation().name())
                .memberName(review.getMember().getName())
                .build();
    }

    //생성용
    //Review 엔터티를 반환 (파라미터는 ReqDTO의 값들)
    public static Review toReview(ReviewReqDTO.CreateReviewDTO dto, Store store, Member member) {
        return Review.builder()
                .reviewContent(dto.getReviewContent())
                .reviewScore(Score.valueOf(dto.getReviewScore())) // 문자열 → enum
                .store(store)
                .member(member)
                .build();
    }

    //Review(엔터티) -> ReviewPreviewDTO
    public static ReviewResDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return ReviewResDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .reviewContent(review.getReviewContent())
                .reviewScore(review.getReviewScore().name())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    // Page<Review> → ReviewPreviewListDTO
    public static ReviewResDTO.ReviewPreviewListDTO toReviewPreviewListDTO(
            org.springframework.data.domain.Page<Review> result
    ) {
        return ReviewResDTO.ReviewPreviewListDTO.builder()
                .reviewList(
                        result.getContent().stream()
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
}