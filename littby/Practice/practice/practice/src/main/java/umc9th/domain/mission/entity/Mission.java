package umc9th.domain.mission.entity;

import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.alarm.entity.Alarm;
import umc9th.domain.store.entity.Restaurant;
import umc9th.global.entity.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "point", nullable = false)
    private long point;

    @Column(name = "rule",length = 25, nullable = false)
    private String rule;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(알람)가 1이다
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(식당)가 1이다
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
