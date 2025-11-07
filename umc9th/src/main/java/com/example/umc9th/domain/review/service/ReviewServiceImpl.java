package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 데이터 변경이 없는 메서드에 대한 읽기 전용 트랜잭션 설정 (성능 최적화)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional // 데이터 변경이 필요하므로, 클래스 레벨의 readOnly 설정을 오버라이드
    public Review createReview(Long memberId, Long storeId, ReviewRequestDTO.CreateReviewDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 사용자를 찾을 수 없습니다."));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 가게를 찾을 수 없습니다."));

        newReview.setUser(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }

    @Override
    public Review createReview(ReviewRequestDTO.CreateReviewDTO request) {
        return null;
    }
}