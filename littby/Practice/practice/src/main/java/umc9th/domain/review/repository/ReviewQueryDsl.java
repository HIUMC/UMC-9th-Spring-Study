package umc9th.domain.review.repository;

import com.querydsl.core.types.Predicate;
import umc9th.domain.review.entity.Review;
import java.util.List;

public interface ReviewQueryDsl {
    List<Review> searchReview(Predicate predicate);
}

