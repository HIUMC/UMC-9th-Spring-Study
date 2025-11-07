package com.example.umc9th.domain.Reply.entity;

import com.example.umc9th.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Lob // TEXT 타입 매핑
    @Column(nullable = false)
    private String content;

    /**
     * 연관관계의 주인 (N:1)
     * - 이 댓글(N)이 어떤 리뷰(1)에 속해있는지 명시
     * - @JoinColumn(name = "review_id"): DB의 'review_id' 컬럼과 매핑
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}