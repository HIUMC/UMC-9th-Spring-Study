package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.Food.entity.Food;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberFoodList().remove(this);
        this.member = member;
        member.getMemberFoodList().add(this);
    }

    public void setFood(Food food) {
        this.food = food;
    }

    // 단일 Food 객체로 MemberFood를 생성하는 메소드
    public static MemberFood createMemberFood(Food food){
        MemberFood memberFood = new MemberFood();
        memberFood.setFood(food);
        return memberFood;
    }

    // Food 리스트로 MemberFood 리스트를 생성하는 새로운 메소드
    public static List<MemberFood> createMemberFoodList(List<Food> foodList){
        return foodList.stream()
                .map(MemberFood::createMemberFood)
                .collect(Collectors.toList());
    }
}
