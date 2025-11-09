package com.example.umc9th.domain.mission.entity.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user_mission")
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private MissionStatus status = MissionStatus.CHALLENGING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    // --- 편의 메서드 ---

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getUserMissionList().remove(this);
        }
        this.member = member;
        member.getUserMissionList().add(this);
    }

    public void setMission(Mission mission) {
        if (this.mission != null) {
            this.mission.getUserMissionList().remove(this);
        }
        this.mission = mission;
        mission.getUserMissionList().add(this);
    }

    public void completeMission() {
        this.status = MissionStatus.COMPLETED;
    }
}
