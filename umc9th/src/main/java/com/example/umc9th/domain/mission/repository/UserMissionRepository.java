package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    // '미션 완료' 시 특정 사용자의 특정 미션을 찾아야 하므로,
    // 사용자(Member)와 미션(Mission)으로 UserMission을 찾는 커스텀 메서드를 추가합니다.
    Optional<UserMission> findByMemberAndMission(Member member, Mission mission);
}