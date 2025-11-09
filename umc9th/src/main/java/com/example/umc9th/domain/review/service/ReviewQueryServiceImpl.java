package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
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

    @Override
    public ReviewResponseDTO.ReviewPreviewListDTO getMyReviewList(Long memberId, Long storeId, Integer rating, Integer page) {
        // Spring's Page starts from 0, so we subtract 1 from the incoming page number.
        Page<Review> reviewPage = reviewRepository.findMyReviews(memberId, storeId, rating, PageRequest.of(page - 1, 10));
        return ReviewConverter.toReviewPreviewListDTO(reviewPage);
    }
}
