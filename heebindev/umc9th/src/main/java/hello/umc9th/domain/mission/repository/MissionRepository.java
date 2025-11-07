package hello.umc9th.domain.mission.repository;

import hello.umc9th.domain.mission.entity.Mission;
import hello.umc9th.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    //    상태가 ACTIVE이고 기간이 유효한 미션만 조회 (페이징)
    Page<Mission> findByStoreStoreIdAndDurationAfterOrderByDurationAsc(
            Long storeId,
            java.time.LocalDateTime now,
            Pageable pageable
    );
}