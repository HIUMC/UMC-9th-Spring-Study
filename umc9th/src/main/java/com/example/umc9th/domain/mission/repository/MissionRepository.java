package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    /**
     * 특정 가게(Store)의 모든 미션을 조회하는 쿼리
     * @param store 가게
     * @return List<Mission>
     */
    @Query("SELECT m FROM Mission m WHERE m.store = :store")
    List<Mission> findAllByStore(@Param("store") Store store);
}
