package com.example.umcworkbook.repository;

import com.example.umcworkbook.dto.res.ReviewDto;
import com.example.umcworkbook.entity.QReview;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewDto> searchReview(
            Predicate predicate
    ){

        QReview review = QReview.review;

        return queryFactory
                .select(
                        Projections.constructor(
                                ReviewDto.class,
                                review.id,
                                review.content,
                                review.star
                        )
                )
                .from(review)
                .where(predicate)
                .fetch();
    }
}
