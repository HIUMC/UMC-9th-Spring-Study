package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.Food.entity.Food;
import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_food_preference") // DB 테이블명
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserFoodPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // DB 컬럼명
    private Long id;

    @Column(name = "selected_at")
    private LocalDateTime selectedAt;

    // --- 연관관계 (N:1) ---

    /**
     * 회원(Member)과의 N:1 연관관계
     * - @JoinColumn(name = "id2"): DB의 'id2' 컬럼을 FK로 사용합니다.
     * (다이어그램의 'id2'가 'user_id'를 참조함)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2")
    private Member member;

    /**
     * 음식(Food)과의 N:1 연관관계
     * - @JoinColumn(name = "food_id2"): DB의 'food_id2' 컬럼을 FK로 사용합니다.
     * (다이어그램의 'food_id2'가 'food_id'를 참조함)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id2")
    private Food food;
}
