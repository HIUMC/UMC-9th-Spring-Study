package com.example.umc9th.service.StoreService;

import com.example.umc9th.domain.review.converter.ReviewConverter; // ReviewConverter import
import com.example.umc9th.domain.review.dto.ReviewResponseDTO; // DTO import
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.exception.handler.StoreHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    // 반환 타입을 ReviewListDTO로 변경
    public ReviewResponseDTO.ReviewListDTO getReviewList(Long storeId, Integer page) {
        // 1. 가게 존재 여부 검증
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        // 에러가 발생했던 메서드 대신, 새로 만든 최적화된 메서드를 호출합니다.
        // page는 1부터 시작하므로, PageRequest에서는 page-1을 해줍니다.
        Page<Review> reviewPage = reviewRepository.findAllByStoreWithMember(store, PageRequest.of(page - 1, 10));
        return ReviewConverter.toReviewListDTO(reviewPage);
    }
}