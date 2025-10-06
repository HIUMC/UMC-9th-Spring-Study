package umc9th.domain.member.entity;


import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.member.enums.FoodName;
import umc9th.global.entity.BaseEntity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodName name;
}
