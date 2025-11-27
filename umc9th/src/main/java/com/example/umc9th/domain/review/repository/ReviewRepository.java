package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 내가 쓴 리뷰 조회 (N+1 해결)
    @Query("SELECT r FROM Review r JOIN FETCH r.member JOIN FETCH r.store WHERE r.member = :member")
    Page<Review> findAllByMemberWithDetails(@Param("member") Member member, Pageable pageable);

    // 가게의 리뷰 조회 (N+1 해결)
    @Query("SELECT r FROM Review r JOIN FETCH r.member WHERE r.store = :store")
    Page<Review> findAllByStoreWithMember(@Param("store") Store store, Pageable pageable);

    // 이전에 에러를 유발했던 findMyReviews 메서드를 완전히 삭제하거나,
    // 아래와 같이 올바른 이름의 메서드로 유지합니다.
    // (이 메서드는 현재 사용되지 않으므로 삭제해도 무방합니다)
    Page<Review> findAllByMemberIdAndStoreIdAndStarGreaterThanEqual(Long memberId, Long storeId, Float rating, Pageable pageable);
}