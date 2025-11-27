package hongikUMC.workbook.domain.mission.repository;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}
