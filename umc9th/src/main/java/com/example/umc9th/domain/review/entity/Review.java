package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.Reply.entity.Reply;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.reviewPhoto.entity.ReviewPhoto;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    /**
     * 리뷰 ID (Primary Key)
     * - @Id: PK임을 명시
     * - @GeneratedValue: 기본 키 생성을 DB에 위임 (AUTO_INCREMENT)
     * - @Column(name = "..."): DB 컬럼명과 필드명이 다를 경우 명시
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    /**
     * 리뷰 내용 (TEXT)
     * - @Lob: TEXT, CLOB 등 대용량 텍스트를 매핑할 때 사용
     */
    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * 리뷰 작성 시간 (DATETIME)
     * - @CreatedDate: Spring Data JPA의 Auditing 기능. 엔티티 생성 시 자동으로 현재 시간을 저장
     * - updatable = false: 이 필드는 생성된 이후 수정되어서는 안 됨
     */
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 별점 (FLOAT)
     * - primitive type(float) 대신 Wrapper class(Float)를 사용하면
     * null 값을 허용할 수 있어 더 유연합니다.
     */
    @Column(name = "star", nullable = false)
    private Float star;

    // --- 연관관계 매핑 ---

    /**
     * 가게 ID (Foreign Key)
     * - @ManyToOne: N:1 연관관계. 리뷰(N)는 가게(1)에 속함.
     * - fetch = FetchType.LAZY: 지연 로딩. 실제 Store 객체를 사용할 때까지 DB 조회를 미룸 (성능 최적화)
     * - @JoinColumn: 외래 키(FK) 컬럼을 명시
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store; // 'Store' 엔티티가 있다고 가정

    /**
     * 회원 ID (Foreign Key)
     * - @ManyToOne: N:1 연관관계. 리뷰(N)는 회원(1)이 작성.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member user; // 'User' 엔티티가 있다고 가정

    /**
     * 이 리뷰에 달린 댓글 목록 (1:N)
     * - mappedBy = "review": 'Reply' 엔티티에 있는 'review' 필드가 연관관계의 주인.
     * - cascade = CascadeType.ALL: 리뷰가 삭제될 때 이 리뷰의 댓글도 모두 함께 삭제.
     */
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    /**
     * 이 리뷰에 첨부된 사진 목록 (1:N)
     * - mappedBy = "review": 'ReviewPhoto' 엔티티에 있는 'review' 필드가 연관관계의 주인.
     */
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewPhoto> reviewPhotos = new ArrayList<>();

}