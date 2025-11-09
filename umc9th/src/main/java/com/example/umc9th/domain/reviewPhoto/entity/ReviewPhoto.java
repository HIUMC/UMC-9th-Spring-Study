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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    // --- 편의 메서드 ---

    public void setReview(Review review) {
        if (this.review != null) {
            this.review.getReviewPhotos().remove(this);
        }
        this.review = review;
        review.getReviewPhotos().add(this);
    }
}