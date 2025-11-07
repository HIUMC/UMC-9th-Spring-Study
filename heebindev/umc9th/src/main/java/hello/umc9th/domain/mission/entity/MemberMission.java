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
@Table(name = "member_mission")
public class MemberMission extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberMissionId;

    // 수행 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 수행 중인 미션
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    //미션 진행 여부
    @Column(name="status",nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.IN_PROGRESS;
}
