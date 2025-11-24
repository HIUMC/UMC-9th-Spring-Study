package com.example.Chapter6.domain.review.repository;

import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.user.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.function.Predicate;

//리뷰 조회
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
    Page<Review> findAllByStore(Store store, Pageable pageable);

    Page<Review> findByMember(Member member, Pageable pageable);
}