package hello.umc9th.domain.mission.entity;

import hello.umc9th.domain.mission.enums.MissionScore;
import hello.umc9th.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    //미션 이름
    @Column(name = "name",nullable = false)
    private String name;

    //미션 내용
    @Column(name = "mission_content", nullable = false, length = 150)
    private String missionContent;

    //미션 스코어
    @Column(name = "mission_score", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MissionScore missionScore =  MissionScore.ONE;

    //미션 기간
    @Column(name = "duration", nullable = false)
    private LocalDateTime duration;

    //연관 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
