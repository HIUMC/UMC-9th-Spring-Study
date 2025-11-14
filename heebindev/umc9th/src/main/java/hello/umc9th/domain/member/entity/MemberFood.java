package hello.umc9th.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member_food") //멤버와 음식의 매핑테이블
public class MemberFood {
    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //==연관관계==//

    @ManyToOne(fetch=FetchType.LAZY)//다대일
    @JoinColumn(name="memberId")
    private Member member; //Member 테이블

    @ManyToOne(fetch=FetchType.LAZY)//다대일
    @JoinColumn(name="foodId")
    private Food food; //Food 테이블
}
