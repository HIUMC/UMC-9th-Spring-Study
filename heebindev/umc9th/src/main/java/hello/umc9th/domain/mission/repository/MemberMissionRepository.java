package hello.umc9th.domain.mission.repository;

import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMemberIdAndStatusInOrderByUpdatedAtDesc(
            Long memberId,
            java.util.List<Status> statuses,
            Pageable pageable
    );

    // SELECT mm FROM MemberMission mm
    // WHERE mm.member.id = :memberId AND mm.status IN (:statuses)
    // ORDER BY mm.updatedAt DESC
}