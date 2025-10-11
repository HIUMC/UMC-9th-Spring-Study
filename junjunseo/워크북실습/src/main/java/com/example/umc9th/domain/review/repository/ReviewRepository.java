package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {

    //내가 작성한 리뷰 (최신순, 페이징)
    Page<Review> findByMemberIdOrderByCreatedAtDesc(Long memberId, Pageable pageable);
}
