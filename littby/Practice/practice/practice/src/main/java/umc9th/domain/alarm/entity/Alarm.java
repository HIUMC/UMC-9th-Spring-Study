package umc9th.domain.alarm.entity;

import jakarta.persistence.*;
import lombok.*;
import umc9th.global.entity.BaseEntity;


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter

@Table(name = "alarm")
public class Alarm extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

