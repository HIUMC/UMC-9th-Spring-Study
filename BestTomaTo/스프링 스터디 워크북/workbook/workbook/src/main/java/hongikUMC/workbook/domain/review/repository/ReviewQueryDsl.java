package hongikUMC.workbook.domain.review.repository;

import com.querydsl.core.types.Predicate;
import hongikUMC.workbook.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryDsl {

    // 검색 API, QueryDSL에서 제공하는 Predicate 객체로 동적 쿼리 작성
    List<Review> searchReview(Predicate predicate);

}
