package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.MemberMission;
import com.example.umcworkbook.entity.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMissionStatus(MissionStatus missionStatus, Pageable pageable);
}
