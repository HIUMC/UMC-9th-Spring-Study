package com.example.umcworkbook.repository;

import com.example.umcworkbook.dto.res.ReviewDto;
import com.querydsl.core.types.Predicate;
import java.util.List;

public interface ReviewQueryDsl {
    List<ReviewDto> searchReview(
            Predicate predicate
    );
}
