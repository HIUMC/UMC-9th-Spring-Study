package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewQueryService {
/*
    public List<Review> searchReview(String query, String type) {

        // Q class 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        //BooleanBuilder 사용

        //동적 쿼리 : 검색 조건
        if (type.equals("location")) {
            builder.and(review.store.location.name.contains(query));
        }
        if (type.equals("star")) {
            builder.and(review.star.goe(Float.parseFloat(query)));
        }
        if (type.equals("both")) {

            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            //동적 쿼리
            builder.and(review.store.location.name.contains(firstQuery));
            builder.and(review.star.goe(Float.parseFloat(firstQuery)));
        }

        //Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

        //리턴
        return reviewList;
    }

    public List<ReviewResDto> getMyReviews(Long memberId, String storeName, Integer starGroup) {
        return reviewRepository.findMyReviews(memberId, storeName, starGroup);
    }
 */

    List<ReviewResDto.ReviewDetailDto> findMyReviews(String type, String query, Float star);

    ReviewResDto.ReviewPreViewListDto findReview(String storeName, Integer page);

    Page<ReviewResDto.MyReviewSummaryDto> findMyReviews(Integer page);
}
