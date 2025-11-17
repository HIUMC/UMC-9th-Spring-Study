package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.entity.Review;

public class ReviewConverter {

    public static ReviewResDto.SearchDto toSearchDto(Review review) {
        return ReviewResDto.SearchDto.builder()
                .reviewId(review.getId())
                .star(review.getStar())
                .content(review.getContent())
                .build();
    }


}
