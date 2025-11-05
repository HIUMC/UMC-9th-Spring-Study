package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant_Dong_Id(Long restaurantDongId, Pageable pageable);
}
