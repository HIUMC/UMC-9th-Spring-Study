package hello.umc9th.domain.mission.repository;

import hello.umc9th.domain.mission.entity.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
