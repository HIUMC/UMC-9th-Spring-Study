package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }

    /*
    @Transactional
    public Long writeReview(Long memberId, float rating, String content) {
        Review review = Review.builder()
                ...
    }
     */
}