package com.example.umc9th.service.StoreService;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

public interface StoreQueryService {
    Page<Review> getReviewList(Long storeId, Integer page);
}
