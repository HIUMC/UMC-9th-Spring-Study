package com.example.umcworkbook.service.command;

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
    public ReviewResDto.SearchDto createReview(Long memberId, Long restaurantId, ReviewReqDto.CreateDto dto) {

        Member member = memberRepository.getReferenceById(memberId);
        Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
        Review review = Review.builder()
                .member(member)
                .restaurant(restaurant)
                .star(dto.star())
                .content(dto.content())
                .build();

        reviewRepository.save(review);

        return ReviewConverter.toSearchDto(review);
    }
}
