package umc9th.domain.mission.entity;


import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.member.entity.Member;
import umc9th.global.entity.BaseEntity;

@Entity
@Table(name = "userMission")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter

public class UserMission extends BaseEntity {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Column(name = "complete")
    private boolean complete = false;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(미션)가 1이다
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(멤버)가 1이다
    @JoinColumn(name = "member_id")
    private Member member;
}

