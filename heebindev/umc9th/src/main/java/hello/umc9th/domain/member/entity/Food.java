package hello.umc9th.domain.member.entity;

import hello.umc9th.domain.member.entity.mapping.MemberFood;
import hello.umc9th.domain.member.enums.FoodCategory;
import hello.umc9th.domain.member.enums.FoodName;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food {
    @Id //PK는 id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //음식이름
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FoodName name;

    //음식 카테고리
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private FoodCategory category;


    @OneToMany(mappedBy = "food")
    private List<MemberFood> memberFoods = new ArrayList<>();
}
