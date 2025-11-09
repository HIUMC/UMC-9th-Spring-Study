package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    /*
    // 검색 API
    @Override
    public List<Review> searchReview(Predicate predicate) {

        // JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // Q클래스 선언
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
     */

    public List<ReviewResponseDto> findMyReviews(String type, String query, Float star) {
        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        BooleanBuilder builder = new BooleanBuilder();

        if ("name".equalsIgnoreCase(type) && query != null) {
            builder.and(store.name.containsIgnoreCase(query));
        } else if ("star".equalsIgnoreCase(type) && star != null) {
            builder.and(review.star.goe(star));
        } else if ("both".equalsIgnoreCase(type) && query != null && star != null) {
            builder.and(store.name.containsIgnoreCase(query))
                    .and(review.star.goe(star));
        }

        return queryFactory
                .select(Projections.constructor(
                        ReviewResponseDto.class,
                        review.id,
                        review.content,
                        review.star,
                        store.name,
                        member.name
                ))
                .from(review)
                .leftJoin(review.store, store)
                .leftJoin(review.member, member)
                .where(builder)
                .fetch();
    }
}

