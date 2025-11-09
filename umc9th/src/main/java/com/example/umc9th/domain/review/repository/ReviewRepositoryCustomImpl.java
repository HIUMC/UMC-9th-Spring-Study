package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.umc9th.domain.member.entity.QMember.member;
import static com.example.umc9th.domain.review.entity.QReview.review;
import static com.example.umc9th.domain.store.entity.QStore.store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Review> findMyReviews(Long memberId, Long storeId, Integer rating, Pageable pageable) {
        List<Review> content = queryFactory
                .selectFrom(review)
                .join(review.member, member)
                .join(review.store, store)
                .where(
                        memberIdEq(memberId),
                        storeIdEq(storeId),
                        ratingMatches(rating)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.createdAt.desc())
                .fetch();

        Long total = queryFactory
                .select(review.count())
                .from(review)
                .join(review.member, member)
                .join(review.store, store)
                .where(
                        memberIdEq(memberId),
                        storeIdEq(storeId),
                        ratingMatches(rating)
                )
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression memberIdEq(Long memberId) {
        return memberId != null ? review.member.id.eq(memberId) : null;
    }

    private BooleanExpression storeIdEq(Long storeId) {
        return storeId != null ? review.store.id.eq(storeId) : null;
    }

    private BooleanExpression ratingMatches(Integer rating) {
        if (rating == null) {
            return null;
        }
        if (rating == 5) {
            return review.star.eq(5.0f);
        }
        float min = rating;
        float max = rating + 0.99f;
        return review.star.between(min, max);
    }
}
