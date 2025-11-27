package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    /**
     * 조회하는 메서드
     * @param member
     * @param mission
     * @return
     */
    boolean existsByMemberAndMission(Member member, Mission mission);



    /**
     * 특정 사용자의 특정 상태의 미션 목록을 페이징하여 조회하는 메서드
     *
     * @param member 조회할 사용자
     * @param status 조회할 미션 상태 (e.g., CHALLENGING)
     * @param pageRequest 페이징 정보 (페이지 번호, 페이지 크기)
     * @return 페이징된 사용자-미션 매핑 정보 (UserMission)
     */
    Page<UserMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

}
