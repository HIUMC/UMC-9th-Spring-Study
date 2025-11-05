package com.example.umc9th.domain.mission.entity.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_mission")
public class UserMission {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // ✅ Member 엔티티 참조
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        private Member member;

        // ✅ Mission 엔티티 참조
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "mission_id")
        private Mission mission;

        // (추가 속성 예시)
        private boolean completed;
}
