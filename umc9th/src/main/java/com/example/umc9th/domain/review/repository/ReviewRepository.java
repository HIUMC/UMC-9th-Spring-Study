package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMember(Member member);

    List<Review> findByStore(Store store);

    @Query("SELECT r FROM Review r WHERE r.store = :store AND r.rating > :rating")
    List<Review> findAllByStoreAndRatingGreaterThan(@Param("store") Store store, @Param("rating") Float rating);
}