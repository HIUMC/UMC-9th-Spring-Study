package umc9th.domain.member.entity.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc9th.domain.member.entity.Food;
import umc9th.domain.member.entity.Member;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member_food")
public class MemberFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 이 엔티티(멤버)가 1이다
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)// 이 엔티티(음식)가 1이다
    @JoinColumn(name = "food_id")
    private Food food;

}
