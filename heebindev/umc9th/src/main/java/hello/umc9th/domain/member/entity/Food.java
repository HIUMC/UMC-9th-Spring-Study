package hello.umc9th.domain.member.entity;

import hello.umc9th.domain.member.enums.FoodName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder //빌더 패턴 사용가능.
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor(access = AccessLevel.PRIVATE) //기본 생성자
@Getter
@Table(name = "food") //DB의 테이블
public class Food {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //음식 이름
    @Column(name="name")
    @Enumerated(EnumType.STRING) //enum 타입은 이렇게 해야지 문자열
    @Builder.Default //디폴트 NONE
    private FoodName name=FoodName.NONE;
}
