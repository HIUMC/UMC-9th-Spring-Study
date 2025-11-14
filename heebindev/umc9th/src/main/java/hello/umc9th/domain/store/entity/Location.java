package hello.umc9th.domain.store.entity;

import hello.umc9th.domain.store.enums.StoreLocation;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="location") //가게 위치 엔터티
public class Location {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="storeLocation", nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreLocation storeLocation;
}
