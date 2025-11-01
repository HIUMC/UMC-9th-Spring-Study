package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
/*
    @GetMapping("/search")
    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {

        //서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(query, type);
        return result;
    }
 */

    @GetMapping("/my")
    public List<ReviewResponseDto> findMyReviews(
            @RequestParam String type,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Float star
    ) {
        return reviewQueryService.findMyReviews(type, query, star);
    }
}
