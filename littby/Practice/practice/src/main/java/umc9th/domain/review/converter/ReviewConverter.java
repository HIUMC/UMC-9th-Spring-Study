package umc9th.domain.review.converter;

import org.springframework.data.domain.Page;
import umc9th.domain.review.entity.Review;
import umc9th.domain.review.dto.ReviewResponseDTO;

import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDTO) // 아래 2-2 메서드 사용
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName()) // 닉네임
                .score(review.getStar())                     // 별점 (Float라고 가정)
                .body(review.getContent())                   // 내용
                .createdAt(review.getCreatedAt().toLocalDate()) // 날짜만 필요할 경우
                .build();
    }


    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
