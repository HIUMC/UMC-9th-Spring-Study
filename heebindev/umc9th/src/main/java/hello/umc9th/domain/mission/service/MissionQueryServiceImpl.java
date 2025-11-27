package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.converter.MissionConverter;
import hello.umc9th.domain.mission.dto.MissionResDTO;
import hello.umc9th.domain.mission.entity.Mission;
import hello.umc9th.domain.mission.repository.MissionRepository;
import hello.umc9th.domain.store.entity.Store;
import hello.umc9th.domain.store.exception.StoreException;
import hello.umc9th.domain.store.exception.code.StoreErrorCode;
import hello.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResDTO.MissionPreviewListDTO getMissionsByStore(Long storeId, Integer page) {

        // 1. 가게 존재 여부 검증
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 2. 페이지 정보 설정 (한 페이지에 10개, page는 1부터 들어옴)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 3. 해당 가게에 속한 미션들을 페이징 조회
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);

        // 4. Page<Mission> → DTO 변환
        return MissionConverter.toMissionPreviewListDTO(result);
    }
}
