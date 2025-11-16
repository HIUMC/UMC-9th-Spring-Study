package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.dto.ReviewCreateRequestDto;
import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }

    public ReviewResponseDto createReview(ReviewCreateRequestDto req) {

        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("임시 멤버가 존재하지 않습니다."));

        Review review = Review.builder()
                .store(store)
                .member(member)
                .star(req.getStar())
                .content(req.getContent())
                .build();

        Review saved = reviewRepository.save(review);

        return ReviewResponseDto.from(saved);
    }

    /*
    @Transactional
    public Long writeReview(Long memberId, float rating, String content) {
        Review review = Review.builder()
                ...
    }
     */
/*
    // 쿼리 테스트
    public String queryTest(String name) {

        // Q클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

        // 결과 확인용 (출력 or return 등)
        return reviewList.toString();
 */
}