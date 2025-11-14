package hello.umc9th.domain.review.repository;

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
public class ReviewQueryDslImpl implements ReviewQueryDsl{
    //ReviewQueryDsl의 구현체

    //의존성 주입! (생성자 주입 by @RequiredArgsConstructor)
    private final EntityManager em;

    //검색 api
    @Override
    public List<Review> searchReview(Predicate predicate){

        //JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        //Q클래스 선언
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate) //동적 쿼리를 위한 객체 predicate (builder)
                .fetch();
    }

    //내 리뷰보기 api
    @Override
    public List<Review> findMyReview(Predicate predicate) {
        //JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        //Q클래스 선언
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
}
