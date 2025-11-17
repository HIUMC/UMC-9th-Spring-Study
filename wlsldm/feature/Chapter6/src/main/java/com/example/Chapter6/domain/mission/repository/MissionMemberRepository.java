package com.example.Chapter6.domain.mission.repository;

import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionMemberRepository extends JpaRepository<MissionMember, Long> {
}
