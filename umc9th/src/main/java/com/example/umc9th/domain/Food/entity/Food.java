package com.example.umc9th.domain.Food.entity;

import com.example.umc9th.domain.Food.enums.FoodName;
import com.example.umc9th.domain.member.entity.mapping.UserFoodPreference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods") // DB 테이블명
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "food_id") // DB 컬럼명
        private Long id;

        @Column(name = "food_name", nullable = false)
        @Enumerated(EnumType.STRING) // Enum 타입을 DB에 문자열로 저장
        private FoodName foodName;

        // --- 연관관계 (1:N) ---
        // 이 음식을 선호하는 '유저-음식 선호' 목록
        // Food(1)는 여러 개의 UserFoodPreference(N)를 가질 수 있음
        @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
        private List<UserFoodPreference> userFoodPreferences = new ArrayList<>();
    }

