package com.example.Chapter6.domain.review.entity;

import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "reviews")
@EntityListeners(AuditingEntityListener.class)

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "stars", length = 1, nullable = false)
    @Builder.Default
    private Float stars = 0.0f;

    @Column(name = "content", nullable = false)
    private String content;

}
