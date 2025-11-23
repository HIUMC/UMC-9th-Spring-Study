package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public List<ReviewResDto.ReviewDetailDto> findMyReviews(String type, String query, Float star) {
        return reviewRepository.findMyReviews(type, query, star);
    }

    @Override
    public ReviewResDto.ReviewPreViewListDto findReview(String storeName, Integer page){
            // - 가게를 가져온다 (가게 존재 여부 검증)
            Store store = storeRepository.findByName(storeName)
                    //    - 없으면 예외 터뜨린다
                    .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

            //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
            PageRequest pageRequest = PageRequest.of(page, 5);
            Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

            //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
            return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public Page<ReviewResDto.MyReviewSummaryDto> findMyReviews(Integer page) {

        int pageIndex = page - 1;

        PageRequest pageable = PageRequest.of(
                pageIndex,
                10,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Long memberId = 1L;

        Page<Review> reviewPage =
                reviewRepository.findByMemberIdOrderByCreatedAtDesc(memberId, pageable);

        return ReviewConverter.toMyReviewSummaryPage(reviewPage);
    }
}
