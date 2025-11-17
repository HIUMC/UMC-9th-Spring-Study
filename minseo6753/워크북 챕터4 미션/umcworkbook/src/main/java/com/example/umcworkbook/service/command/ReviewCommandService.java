package com.example.umcworkbook.service.command;

import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto;

public interface ReviewCommandService {
    ReviewResDto.SearchDto createReview(Long memberId, Long restaurantId, ReviewReqDto.CreateDto dto);
}
