package hello.umc9th.domain.mission.repository;

import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    //특정 회원의 진행중(IN_PROGRESS) 미션들 페이징 조회
    Page<MemberMission> findAllByMemberIdAndMissionStatus(
            Long memberId,
            Status missionStatus,
            PageRequest pageRequest
    );
}
