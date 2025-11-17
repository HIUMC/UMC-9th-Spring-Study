package com.example.Chapter6.domain.review.converter;

import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.user.entity.Member;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.reviewDTO dto,
                                  Store store, Member member) {
        return Review.builder()
                .store(store)
                .member(member)
                .content(dto.content())
                .stars(dto.stars())
                .build();
    }
}
