package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.dto.res.ReviewResDto.MyReviewDto;
import com.example.umcworkbook.entity.Review;
import java.time.LocalDate;
import org.springframework.data.domain.Page;

public class ReviewConverter {

    public static MyReviewDto toMyReviewDto(Review review) {
        return MyReviewDto.builder()
                .reviewId(review.getId())
                .star(review.getStar())
                .content(review.getContent())
                .build();
    }

    public static ReviewResDto.PreviewDto toPreviewDto(
            Review review
    ) {
        return ReviewResDto.PreviewDto.builder()
                .memberNickName(review.getMember().getNickname())
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }

    public static ReviewResDto.PreviewListDto toPreviewListDto(
            Page<Review> result
    ){
        return ReviewResDto.PreviewListDto.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toPreviewDto)
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
