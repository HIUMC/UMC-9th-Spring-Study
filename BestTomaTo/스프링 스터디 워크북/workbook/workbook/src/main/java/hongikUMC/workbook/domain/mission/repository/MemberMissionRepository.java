package hongikUMC.workbook.domain.mission.repository;

import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
