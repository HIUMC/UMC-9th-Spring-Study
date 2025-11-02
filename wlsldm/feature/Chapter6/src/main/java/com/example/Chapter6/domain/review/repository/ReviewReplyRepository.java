package com.example.Chapter6.domain.review.repository;

import com.example.Chapter6.domain.review.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//리뷰 답글 작성
public interface ReviewReplyRepository extends JpaRepository<Review, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO review_reply (review_id, context) VALUES (:reviewId, :context)", nativeQuery = true)
    void insertReply(@Param("reviewId") long reviewId,
                     @Param("context") String context);
}