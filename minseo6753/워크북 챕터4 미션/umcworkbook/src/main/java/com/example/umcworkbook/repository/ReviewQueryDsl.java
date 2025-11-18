package com.example.umcworkbook.repository;

import com.example.umcworkbook.dto.res.ReviewResDto.MyReviewDto;
import com.querydsl.core.types.Predicate;
import java.util.List;

public interface ReviewQueryDsl {
    List<MyReviewDto> searchReview(
            Predicate predicate
    );
}
