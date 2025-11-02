package com.example.Chapter6.domain.review.repository;

import com.example.Chapter6.domain.review.entity.QReview;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.store.entity.QRegion;
import com.example.Chapter6.domain.store.entity.QStore;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{
    //private final ReviewRepository reviewRepository;
    //private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    QReview review = QReview.review;
    QStore store = QStore.store;
    QRegion region = QRegion.region;

    @Override
    public List<Review> searchReview (
            Predicate predicate
    ){

        QReview review = QReview.review;
        return queryFactory
                .selectFrom(review)
                .leftJoin(store).on(store.id.eq(review.store.id))
                .leftJoin(region).on(region.id.eq(store.region.id))
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Review> myReview(
            Predicate predicate
    ){
        QReview review = QReview.review;
        return queryFactory
                .selectFrom(review)
                .leftJoin(store).on(store.id.eq(review.store.id))
                .where(predicate)
                .fetch();

    }



}
