package com.example.Chapter6.domain.review.service.command;

import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;

public interface ReviewCommandService {

    //리뷰 작성
    ReviewResponseDTO review(ReviewRequestDTO.reviewDTO dto);
}
