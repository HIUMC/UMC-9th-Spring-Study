package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.enums.Address;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    //선택된 동에서 마감일이 오늘 이후이고, 현재 회원이 아직 도전하지 않은 미션을 페이지로 조회
    @Query("""
        select m.id          as missionId,
               s.name        as storeName,
               m.conditional as conditionalText,
               m.point       as point,
               m.deadline    as deadline
          from Mission m
          join m.store s
          join s.location l
          where l.name = :name
           and m.deadline >= :today
           and not exists (
                select 1 from MemberMission mm
                 where mm.mission = m
                   and mm.member.id = :memberId
           )
        """)
    Page<HomeCardView> findAvailableForHomeByLocationName(
            @Param("memberId") Long memberId,
            @Param("name") String name,
            @Param("today") LocalDate today,
            Pageable pageable
    );
}
