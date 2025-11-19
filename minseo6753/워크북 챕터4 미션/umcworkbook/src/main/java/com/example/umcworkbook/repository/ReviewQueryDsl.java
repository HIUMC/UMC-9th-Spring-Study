package com.example.umcworkbook.repository;

import com.example.umcworkbook.dto.res.ReviewResDto;
import com.querydsl.core.types.Predicate;
import java.util.List;

public interface ReviewQueryDsl {
    List<ReviewResDto.MyReviewDto> searchReview(
            Predicate predicate
    );
}
