package com.example.Chapter6.domain.review.controller;

import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/review/search")
    public List<Review> search(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> result = reviewService.searchReview(query, type);
        return result;
    }

    @GetMapping("/review/my")
    public List<Review> myReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> result = reviewService.myReview(query, type);
        return result;
    }
}
