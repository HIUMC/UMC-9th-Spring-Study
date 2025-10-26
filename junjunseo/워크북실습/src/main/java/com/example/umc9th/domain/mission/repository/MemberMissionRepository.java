package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {

    //특정 회원의 진행중인 미션 목록
    Page<MemberMission> findByMemberIdAndIsCompleteFalseOrderByCreatedAtDesc(Long memberId, Boolean isComplete, Pageable pageable);

    //특정 회원의 완료한 미션 목록
    Page<MemberMission> findByMemberIdAndIsCompleteTrueOrderByCreatedAtDesc(Long memberId, Boolean isComplete, Pageable pageable);
}
