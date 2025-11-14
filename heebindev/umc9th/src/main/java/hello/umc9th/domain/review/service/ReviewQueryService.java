package hello.umc9th.domain.review.service;


import com.querydsl.core.BooleanBuilder;
import hello.umc9th.domain.review.converter.ReviewConverter;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.QReview;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.review.exception.ReviewException;
import hello.umc9th.domain.review.exception.code.ReviewErrorCode;
import hello.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public List<ReviewResDTO.ReviewInfo> searchReview(String type, String query) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 타입 검증
        if (!type.equals("location") && !type.equals("score") && !type.equals("both")) {
            throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
        }

        // location 검색
        if (type.equals("location")) {
            builder.and(review.store.location.storeLocation.stringValue().contains(query));
        }

        // score 검색
        if (type.equals("score")) {
            try {
                builder.and(review.reviewScore.eq(Score.valueOf(query)));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        // both 검색
        if (type.equals("both")) {
            String[] parts = query.split("&");
            if (parts.length != 2) throw new ReviewException(ReviewErrorCode.INVALID_FILTER);

            builder.and(review.store.location.storeLocation.stringValue().contains(parts[0]));

            try {
                builder.and(review.reviewScore.eq(Score.valueOf(parts[1])));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        // 검색 실행
        List<Review> reviews = reviewRepository.searchReview(builder);

        return reviews.stream()
                .map(ReviewConverter::toReviewInfo)
                .toList();
    }
    /// 내 리뷰 apiii
    public List<ReviewResDTO.ReviewInfo> searchMyReview(String type, String query) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // type 검증
        if (!type.equals("store") && !type.equals("score")) {
            throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
        }

        // 💡 store 필터링
        if (type.equals("store")) {
            try {
                long storeId = Long.parseLong(query);
                builder.and(review.store.id.eq(storeId));
            } catch (NumberFormatException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
            }
        }

        // 💡 score 필터링
        if (type.equals("score")) {
            try {
                builder.and(review.reviewScore.eq(Score.valueOf(query)));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        List<Review> reviewList = reviewRepository.findMyReview(builder);

        return reviewList.stream()
                .map(ReviewConverter::toReviewInfo)
                .toList();
    }
}