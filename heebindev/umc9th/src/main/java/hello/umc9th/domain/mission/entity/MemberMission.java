package hello.umc9th.domain.mission.entity;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.mission.enums.Status;
import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "memberMission")
public class MemberMission extends BaseEntity {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //진행 상황
    @Column(name="missionStatus",nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status missionStatus= Status.IN_PROGRESS;

    //==연관관계==//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId",nullable=false)
    private Member member; //member 테이블

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missionId",nullable = false)
    private Mission mission; //mission 테이블
}

