package umc9th.domain.review.entity;


import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.alarm.entity.Alarm;
import umc9th.domain.member.entity.Member;
import umc9th.domain.store.entity.Restaurant;
import umc9th.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "star", nullable = false)
    private int star;

    @Column(name = "contet", length = 100, nullable = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(유저)가 1이다
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(식당)가 1이다
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(알람)가 1이다
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;
}
