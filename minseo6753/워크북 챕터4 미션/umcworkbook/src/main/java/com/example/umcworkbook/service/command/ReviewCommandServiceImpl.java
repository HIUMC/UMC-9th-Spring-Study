package com.example.umcworkbook.service.command;

import com.example.umcworkbook.apiPayload.code.error.MemberErrorCode;
import com.example.umcworkbook.apiPayload.code.error.RestaurantErrorCode;
import com.example.umcworkbook.apiPayload.exception.MemberException;
import com.example.umcworkbook.apiPayload.exception.RestaurantException;
import com.example.umcworkbook.converter.ReviewConverter;
import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.entity.Member;
import com.example.umcworkbook.entity.Restaurant;
import com.example.umcworkbook.entity.Review;
import com.example.umcworkbook.repository.MemberRepository;
import com.example.umcworkbook.repository.RestaurantRepository;
import com.example.umcworkbook.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResDto.MyReviewDto createReview(Long memberId, Long restaurantId, ReviewReqDto.CreateDto dto) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .restaurant(restaurant)
                .star(dto.star())
                .content(dto.content())
                .build();

        reviewRepository.save(review);

        return ReviewConverter.toMyReviewDto(review);
    }
}
