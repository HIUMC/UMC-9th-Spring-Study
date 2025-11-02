package com.example.Chapter6.domain.review.repository;


import com.example.Chapter6.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {

    List<Review> searchReview (
      Predicate predicate
    );

    List<Review> myReview (
            Predicate predicate
    );

}