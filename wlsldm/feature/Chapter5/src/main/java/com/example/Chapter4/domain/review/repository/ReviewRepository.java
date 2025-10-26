package com.example.Chapter4.domain.review.repository;

import com.example.Chapter4.domain.review.entity.Review;
import com.example.Chapter4.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//리뷰 조회
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStore(Store store);
}