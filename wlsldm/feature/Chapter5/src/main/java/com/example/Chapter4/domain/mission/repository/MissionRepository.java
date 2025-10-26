package com.example.Chapter4.domain.mission.repository;

import com.example.Chapter4.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    //미션 페이지 쿼리
    @Query("SELECT s.name, m.content, m.point " +
            "FROM MissionMember um " +
            "JOIN um.mission m " +
            "JOIN m.store s " +
            "WHERE um.member.id = :userId AND um.complete = :isComplete " +
            "ORDER BY m.id DESC")
    List<Object[]> findMission(
            @Param("userId") Long userId,
            @Param("isComplete") Boolean isComplete, //true시 진행 완료, false시 진행 중
            Pageable page//페이징
    );

    //홈화면 현재 지역 도전 가능한 미션 목록
    @Query("SELECT s.name, m.expiredAt, m.content, m.point " +
            "FROM Mission m " +
            "JOIN m.store s " +
            "JOIN s.region r " +
            "WHERE r.name = :region"
    )
    List<Object[]> findRegionMission(
            @Param("region") String region,
            Pageable page
    );


    //홈 화면 미션 달성 개수
    @Query("SELECT COUNT(m.id) " +
            "FROM Mission m " +
            "WHERE m.id IN (" +
                "SELECT um.mission.id " +
                "FROM MissionMember um " +
                "WHERE um.complete = 'SUCCESS' AND um.member.id = :memberId)"
    )
    int countMissions(@Param("memberId") Long memberId);

}
