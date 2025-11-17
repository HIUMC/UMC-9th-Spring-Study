package com.example.Chapter6.domain.user.service.command;

import com.example.Chapter6.domain.user.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
