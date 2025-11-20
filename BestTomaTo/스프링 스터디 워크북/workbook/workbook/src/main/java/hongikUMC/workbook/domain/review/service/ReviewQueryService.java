package hongikUMC.workbook.domain.review.service;

import com.querydsl.core.BooleanBuilder;
import hongikUMC.workbook.domain.review.entity.QReview;
import hongikUMC.workbook.domain.review.entity.Review;

import java.util.List;

public class ReviewQueryService {

    public List<Review> searchReview(String query, String type){

        // Q클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리
        if (type.equals("region")) {
            // builder.and(review.store.region.name.contains(query));
        }

        return null;
    }
}
