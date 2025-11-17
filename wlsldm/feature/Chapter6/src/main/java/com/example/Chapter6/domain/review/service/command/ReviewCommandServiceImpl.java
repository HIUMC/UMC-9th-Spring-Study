package com.example.Chapter6.domain.review.service.command;

import com.example.Chapter6.domain.review.converter.ReviewConverter;
import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.review.repository.ReviewRepository;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.store.repository.StoreRepository;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    //리뷰 작성
    @Override
    public ReviewResponseDTO review(ReviewRequestDTO.reviewDTO dto){
         Store store = storeRepository.findById(dto.storeId())
                 .orElseThrow(()-> new RuntimeException("가게를 찾을 수 없습니다"));
         Member member = memberRepository.findById(dto.memberId())
                 .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다"));

         Review review = Review.builder()
                 .store(store)
                 .member(member)
                 .stars(dto.stars())
                 .content(dto.content())
                 .build();

         Review savedReview = reviewRepository.save(review);

         return ReviewResponseDTO.from(savedReview);
    }
}
