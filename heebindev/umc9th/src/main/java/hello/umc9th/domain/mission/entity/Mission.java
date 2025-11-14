package hello.umc9th.domain.mission.entity;

import hello.umc9th.domain.store.entity.Store;
import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission") //mission 테이블
public class Mission extends BaseEntity {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //미션 기한
    @Column(name="missionDeadline")
    private LocalDateTime missionDeadline;

    //미션 내용
    @Column(name="missionContent",nullable = false)
    private String missionContent;

    //미션 점수
    @Column(name="point",nullable = false)
    @Builder.Default
    private int point=0;

    //생성, 수정, 삭제 일자는 상속.

    //==연관관계==//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="storeId")
    private Store store; //Store 테이블
}
