package hello.umc9th.domain.review.repository;

import com.querydsl.core.types.Predicate;
import hello.umc9th.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryDsl {
    //검색 api
    List<Review> searchReview(Predicate predicate);

    //내 리뷰 보기 api
    List<Review> findMyReview(Predicate predicate);
}
