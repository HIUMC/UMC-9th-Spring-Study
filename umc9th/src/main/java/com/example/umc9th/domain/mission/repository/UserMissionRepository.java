package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
