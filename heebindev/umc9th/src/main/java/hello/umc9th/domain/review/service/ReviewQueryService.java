package hello.umc9th.domain.review.service;

import com.querydsl.core.BooleanBuilder;
import hello.umc9th.domain.review.entity.QReview;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String type, String query) {//검색 메서드
        //Q클래스 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        //booleanBuilder는 빈 컨테이너다.
        BooleanBuilder builder = new BooleanBuilder();

        //BooleanBuilder 사용 where절을 위함.
        //동적 쿼리 : 검색 조건
        if (type.equals("location")) { //지역검색
            builder.and(review.store.location.storeLocation.stringValue().contains(query));
        }
        if (type.equals("score")) {//점수 검색
            builder.and(review.reviewScore.eq(Score.valueOf(query)));
        }
        if (type.equals("both")) {
            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            //동적 쿼리: 검색 조건
            builder.and(review.store.location.storeLocation.stringValue().contains(firstQuery));
            builder.and(review.reviewScore.eq(Score.valueOf(secondQuery)));
        }

        //Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

        //리턴
        return reviewList;
    }



}

