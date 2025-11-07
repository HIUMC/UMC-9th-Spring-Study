package hello.umc9th.domain.review.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.umc9th.domain.review.entity.QReview;
import hello.umc9th.domain.review.entity.Review;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    //나의 리뷰 찾기 (필터링)
    @Override
    public List<Review> findMyReviews(Long memberId, String storeName, Double minStar,Double maxStar) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em); //JPA 세팅
        QReview review = QReview.review; //Q클래스 선언

        BooleanBuilder builder = new BooleanBuilder();

        if (memberId != null) {
            builder.and(review.member.memberId.eq(memberId));
        }
        if ((storeName != null)){
            builder.and(review.store.name.eq(storeName));
        }
        if (maxStar != null && minStar != null) {
            builder.and(review.store.averageScore.between(minStar,maxStar));
        }

        return queryFactory.selectFrom(review).where(builder).fetch();
    }

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

}


