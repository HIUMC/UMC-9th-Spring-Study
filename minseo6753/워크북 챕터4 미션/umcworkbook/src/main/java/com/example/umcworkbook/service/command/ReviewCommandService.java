package com.example.umcworkbook.service.command;

import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto.MyReviewDto;

public interface ReviewCommandService {
    MyReviewDto createReview(Long memberId, Long restaurantId, ReviewReqDto.CreateDto dto);
}
