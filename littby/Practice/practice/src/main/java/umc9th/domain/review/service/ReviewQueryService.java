package umc9th.domain.review.service;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc9th.domain.review.entity.QReview;
import umc9th.domain.member.entity.QMember;
import umc9th.domain.store.entity.QRestaurant;

import umc9th.domain.review.entity.Review;
import umc9th.domain.review.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String storeName, Integer starRange, Long memberId) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 내가 쓴 리뷰만
        builder.and(review.member.id.eq(memberId));

        // 가게 이름 필터
        if (storeName != null && !storeName.isBlank()) {
            builder.and(review.restaurant.name.eq(storeName));
        }

        // 별점 필터 (4점대 -> 4.0~4.9)
        if (starRange != null) {
            builder.and(review.star.between(starRange, starRange + 0.9));
        }

        // 결과 리턴
        return reviewRepository.searchReview(builder);
    }
}
