package UMC.week4.repository;

import UMC.week4.domain.UserMission;
import UMC.week4.domain.enums.MissionStatus;
import UMC.week4.domain.enums.Region;
import UMC.week4.dto.InprogressMissionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("SELECT new UMC.week4.dto.InprogressMissionDto(s.title, m.content, m.point, um.isComplete) " +
            "FROM UserMission um JOIN um.mission m JOIN m.store s " +
            "WHERE um.member.id = :memberId AND um.isComplete = 'IN_PROGRESS' " +
            "ORDER BY m.createdAt DESC")
    Page<InprogressMissionDto> findInProgressMissions(@Param("userId") Long memberId, Pageable pageable);

    long countByMember_IdAndMission_Store_RegionAndIsComplete(Long userId, Region region, MissionStatus isComplete);
}
