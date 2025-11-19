package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Mission;
import com.example.umcworkbook.entity.Restaurant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant_Dong_Id(Long restaurantDongId, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"restaurant"})
    Optional<Mission> findById(Long aLong);

    @EntityGraph(attributePaths = {"restaurant","restaurant.category"})
    Page<Mission> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
