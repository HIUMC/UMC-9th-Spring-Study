package umc9th.domain.mission.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc9th.domain.member.entity.Member;
import umc9th.domain.mission.entity.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT new com.example.dto.userMissionResponse(
            um.id,
            m.id,
            m.point,
            m.condition,
            m.deadline,
            r.name,
            um.complete,
            um.createdAt
        )
        FROM UserMission um
        JOIN um.mission m
        JOIN m.restaurant r
        WHERE um.member.id = :memberId
        ORDER BY um.createdAt DESC
    """)
    List<UserMissionResponse> findByMemberId(@Param("memberId") Long memberId);

    Page<UserMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);
}


