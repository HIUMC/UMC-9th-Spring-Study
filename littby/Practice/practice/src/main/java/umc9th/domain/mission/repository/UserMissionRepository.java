package umc9th.domain.mission.repository;

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
}
}

