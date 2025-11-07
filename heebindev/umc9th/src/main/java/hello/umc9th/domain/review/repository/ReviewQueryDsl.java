package hello.umc9th.domain.review.repository;

import com.querydsl.core.types.Predicate;
import hello.umc9th.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryDsl {
    // 검색 API
    List<Review> searchReview(
            Predicate predicate
    );

    List<Review> findMyReviews(
            Long memberId, String storeName, Double minStar ,Double maxStar
    );
}
