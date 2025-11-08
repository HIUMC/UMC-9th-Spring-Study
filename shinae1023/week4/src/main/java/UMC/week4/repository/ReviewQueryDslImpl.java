package UMC.week4.repository;

import UMC.week4.domain.QReview;
import UMC.week4.domain.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static UMC.week4.domain.QMember.member;
import static UMC.week4.domain.QReview.review;
import static UMC.week4.domain.QStore.store;

@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public List<Review> searchReview(
            Predicate predicate
    ){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }

    @Override
    public Page<Review> findMyReviews(Long memberId, String storeName, Integer starRating, Pageable pageable) {

        // [1] 내용(Content) 쿼리
        List<Review> content = queryFactory
                .selectFrom(review)
                .join(review.store, store) // 가게와 조인
                .join(review.member, member) // 사용자와 조인
                .where(
                        member.id.eq(memberId),         // ★ 1. "내가 쓴" 리뷰 (필수)
                        storeNameEq(storeName),         // ★ 2. 가게 이름 (동적)
                        starRatingBetween(starRating)   // ★ 3. 별점 (동적)
                )
                .orderBy(review.createdAt.desc()) // 최신순 정렬 (예시)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // [2] 전체 개수(Count) 쿼리
        Long totalCount = queryFactory
                .select(review.count())
                .from(review)
                .join(review.store, store)
                .join(review.member, member)
                .where(
                        member.id.eq(memberId),         // ※ count 쿼리에도 where 조건은 동일하게!
                        storeNameEq(storeName),
                        starRatingBetween(starRating)
                )
                .fetchOne();

        // [3] Page 객체로 변환하여 반환
        return new PageImpl<>(content, pageable, totalCount);
    }

    private BooleanExpression storeNameEq(String storeName) {
        // StringUtils.hasText() : null, "", " "(공백)이 아닌 경우 true
        return StringUtils.hasText(storeName) ? store.title.eq(storeName) : null;
    }

    // 3. 별점(starRating) 필터
    private BooleanExpression starRatingBetween(Integer starRating) {
        if (starRating == null) {
            return null; // 별점 필터링 안 함
        }

        float minStar = starRating.floatValue();

        if (starRating == 5) {
            // "5점" -> 5.0점만
            return review.star.eq((int) minStar);
        } else if (starRating >= 1 && starRating <= 4) {
            // "4점대" -> 4.0 <= star < 5.0
            // "3점대" -> 3.0 <= star < 4.0
            float maxStar = minStar + 1.0f;
            return review.star.goe(minStar).and(review.star.lt(maxStar));
        } else {
            return null; // 0점 등 유효하지 않은 값은 무시
        }
    }

}
