package com.example.umc9th.domain.reviewPhoto.entity;

import com.example.umc9th.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_photo_id")
    private Long id;

    @Column(name = "review_photo_url", nullable = false)
    private String reviewPhotoUrl;

    /**
     * 연관관계의 주인 (N:1)
     * - 이 사진(N)이 어떤 리뷰(1)에 속해있는지 명시
     * - @JoinColumn(name = "review_id"): DB의 'review_id' 컬럼과 매핑
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}