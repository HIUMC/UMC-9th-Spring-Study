package hello.umc9th.domain.mission.repository;

import hello.umc9th.domain.mission.entity.Mission;
import hello.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    // 특정 가게에 속한 미션들을 페이징 조회
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
