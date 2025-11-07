package umc9th.domain.mission.repository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT new com.example.dto.HomeMissionResponse(
            m.id,
            m.point,
            m.condition,
            m.deadline,
            r.name,
            l.name
        )
        FROM Mission m
        JOIN m.restaurant r
        JOIN r.locate l
        LEFT JOIN UserMission um
            ON um.mission.id = m.id AND um.member.id = :memberId
        WHERE l.id = :locateId
        AND (um.member.id IS NULL OR um.complete = false)
        ORDER BY m.deadline ASC
    """)
    List<HomeMissionResponse> findAvailableMissions(
            @Param("memberId") Long memberId,
            @Param("locateId") Long locateId
    );
}
