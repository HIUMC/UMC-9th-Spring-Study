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
@Table(name = "review")//리뷰 테이블
public class Review extends BaseEntity{
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //리뷰 내용
    @Column(name="reviewContent")
    private String reviewContent;

    //별점
    @Column(name="reviewScore")
    private Score reviewScore;

    //생성, 수정, 삭제 일자는 상속받음

    //==연관관계==//
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="storeId", nullable = false)
    private Store store; //가게 테이블

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId", nullable = false)
    private Member member; //멤버 테이블

}
