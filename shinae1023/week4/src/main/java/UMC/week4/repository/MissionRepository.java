package UMC.week4.repository;

import UMC.week4.domain.Mission;
import UMC.week4.domain.enums.Region;
import UMC.week4.dto.AvailableMissionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    long countByStore_Region(Region region);

    @Query("SELECT new UMC.week4.dto.AvailableMissionDto (m.title, s.title, m.content, m.point, " +
            "  CASE " +
            "    WHEN um.isComplete = 'IN_PROGRESS' THEN '진행 중' " +
            "    WHEN um.isComplete = 'COMPLETED' THEN '진행 완료' " +
            "    ELSE '미션 도전' " +
            "  END) " +
            "FROM Mission m JOIN m.store s " +
            "LEFT JOIN UserMission um ON um.mission = m AND um.member.id = :memberId " +
            "WHERE s.region = :region")
    Page<AvailableMissionDto> findAvailableMissions(@Param("memberId") Long memberId, @Param("region") Region region, Pageable pageable);
}
