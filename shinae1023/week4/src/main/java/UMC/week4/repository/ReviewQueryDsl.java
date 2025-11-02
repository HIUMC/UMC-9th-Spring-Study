package UMC.week4.repository;

import UMC.week4.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewQueryDsl {

    List<Review> searchReview(
            com.querydsl.core.types.Predicate predicate
    );

    Page<Review> findMyReviews(Long memberId, String storeName, Integer starRating, Pageable pageable);
}
