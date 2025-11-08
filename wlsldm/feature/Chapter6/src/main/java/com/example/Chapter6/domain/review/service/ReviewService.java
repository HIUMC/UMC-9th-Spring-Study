package com.example.Chapter6.domain.review.service;

import com.example.Chapter6.domain.review.entity.QReview;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ){
        //Q클래스 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 동적 쿼리: 검색 조건
        if (type.equals("location")) {
            builder.and(review.store.region.name.contains(query));
        }
        if (type.equals("star")) {
            builder.and(review.stars.goe(Float.parseFloat(query)));
        }
        if (type.equals("both")) {

            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            // 동적 쿼리
            builder.and(review.store.region.name.contains(firstQuery));
            builder.and(review.stars.goe(Float.parseFloat(secondQuery)));
        }

// Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

// 리턴
        return reviewList;
    }

    public List<Review> myReview(
            @RequestParam String query,
            @RequestParam String type
    ){
        //Q클래스 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 동적 쿼리: 필터
        if (type.equals("store")) {
            builder.and(review.store.name.eq(query));
        }
        if (type.equals("star")) {
            builder.and(review.stars.goe(Float.parseFloat(query)))
                    .and(review.stars.lt(Float.parseFloat(query+1)));
        }
        // Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

// 리턴
        return reviewList;
    }
}
