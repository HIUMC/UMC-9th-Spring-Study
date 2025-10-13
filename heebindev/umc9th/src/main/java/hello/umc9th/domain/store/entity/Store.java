package hello.umc9th.domain.store.entity;

import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="store")

public class Store extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //가게 이름
    @Column(name = "name", nullable = false)
    private String name;

    //주소
    @Column(name = "address",nullable = false)
    private String address;
}
