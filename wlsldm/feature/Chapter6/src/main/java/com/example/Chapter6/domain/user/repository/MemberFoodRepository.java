package com.example.Chapter6.domain.user.repository;

import com.example.Chapter6.domain.user.entity.mapping.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {
}
