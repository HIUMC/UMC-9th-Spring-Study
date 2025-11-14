package hello.umc9th.domain.store.entity;

import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="store")//가게 테이블
public class Store extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //가게 이름
    @Column(name = "name", nullable = false)
    private String name;

    //주소
    @Column(name = "storeAddress",nullable = false)
    private String address;

    //평균 별점
    @Column(name = "averageScore")
    private Double averageScore;

    //생성, 수정, 삭제 일자는 상속받음.

    //==연관관계==//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="locationId")
    private Location location;//Location 테이블
}
