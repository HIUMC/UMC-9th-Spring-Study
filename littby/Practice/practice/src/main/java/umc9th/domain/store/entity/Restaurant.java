package umc9th.domain.store.entity;


import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.alarm.entity.Alarm;
import umc9th.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "restaurant")

public class Restaurant extends BaseEntity  {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 25,nullable = false)
    private String name;

    @Column(name = "address", length = 20, nullable = false)
    private String address;

    @Column(name = "chefNumber", nullable = false)
    private Long chefNumber;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(지역)가 1이다
    @JoinColumn(name = "locate_id")
    private Locate locate;
}
