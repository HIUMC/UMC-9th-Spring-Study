package com.example.umc9th.domain.Food.repository;

import com.example.umc9th.domain.Food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
