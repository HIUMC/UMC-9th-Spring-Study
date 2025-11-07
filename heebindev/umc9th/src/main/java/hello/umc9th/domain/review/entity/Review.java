package hello.umc9th.domain.review.entity;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.store.entity.Store;
import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review extends BaseEntity {
    //연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store restaurant;

    @Id //pk는 id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    //리뷰 내용
    @Column(name = "review_content",length = 150)
    private String reviewContent;

    //별점
    @Column(name = "score", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Score score =  Score.ONE;
}
