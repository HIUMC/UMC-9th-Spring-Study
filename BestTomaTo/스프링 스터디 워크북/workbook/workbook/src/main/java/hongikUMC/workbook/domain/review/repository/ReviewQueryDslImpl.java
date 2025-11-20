package hongikUMC.workbook.domain.review.repository;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hongikUMC.workbook.domain.review.entity.QReview;
import hongikUMC.workbook.domain.review.entity.Review;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{

    private final ReviewRepository reviewRepository;
    private final EntityManager em;

    @Override
    public List<Review> searchReview(Predicate predicate) {

        // JPA 쿼리 세팅
        // QueryDSL도 내부적으로는 JPA를 사용하니까 영속성 컨텍스트와 연동하는 과정을 거쳐야 한다.
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // Q클래스 선언
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }


}
