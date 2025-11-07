package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.entity.Mission;
import hello.umc9th.domain.mission.enums.Status;
import hello.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;

    public Page<Mission> getAvailableMissionsByStore(Long storeId, int page, int size) {
        LocalDateTime now = LocalDateTime.now();
        PageRequest pageRequest = PageRequest.of(page, size);

        return missionRepository.findByStoreStoreIdAndDurationAfterOrderByDurationAsc(
                storeId,
                now,
                pageRequest
        );
    }
}