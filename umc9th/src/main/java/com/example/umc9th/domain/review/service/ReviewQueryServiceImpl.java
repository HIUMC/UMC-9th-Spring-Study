package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.exception.handler.MemberHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public ReviewResponseDTO.ReviewListDTO getMyReviewList(Long memberId, Long storeId, Float rating, Integer page) {
        // 1. 올바른 이름의 Repository 메서드를 호출합니다.
        Page<Review> reviewPage = reviewRepository.findAllByMemberIdAndStoreIdAndStarGreaterThanEqual(
                memberId, storeId, rating, PageRequest.of(page - 1, 10)
        );

        // 2. DTO로 변환하여 반환합니다.
        return ReviewConverter.toReviewListDTO(reviewPage);
    }

    @Override // 인터페이스의 메서드를 구현한다는 의미의 어노테이션
    public ReviewResponseDTO.ReviewListDTO getReviewList(Long memberId, Integer page) {
        // 1. 사용자 존재 여부 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        // 2. 페이징 처리하여 리뷰 목록 조회 (N+1 문제 해결된 쿼리 사용)
        Page<Review> reviewPage = reviewRepository.findAllByMemberWithDetails(member, PageRequest.of(page - 1, 10));

        // 3. DTO로 변환하여 반환
        return ReviewConverter.toReviewListDTO(reviewPage);
    }
}
