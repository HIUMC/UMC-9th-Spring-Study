package hongikUMC.workbook.domain.store.service;

import hongikUMC.workbook.domain.store.converter.StoreConverter;
import hongikUMC.workbook.domain.store.dto.req.StoreReqDTO;
import hongikUMC.workbook.domain.store.dto.res.StoreResDTO;
import hongikUMC.workbook.domain.store.entity.Region;
import hongikUMC.workbook.domain.store.entity.Store;
import hongikUMC.workbook.domain.store.exception.RegionException;
import hongikUMC.workbook.domain.store.exception.code.RegionErrorCode;
import hongikUMC.workbook.domain.store.repository.RegionRepository;
import hongikUMC.workbook.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    // 상점 저장
    public StoreResDTO.saveStoreDTO saveStore(
            StoreReqDTO.saveStoreDTO dto
    ){
        // 스토어 변환
        Store store = StoreConverter.toStore(dto);

        // 지역은 RegionRepository에서 꺼내와 객체로 저장
        // DB에서는 외래키 참조로 보여지게 됨.
        // 다대다 관계는 아니기 때문에 이렇게 저장.
        Region region = regionRepository.findById(dto.region()).
                orElseThrow(() -> new RegionException(RegionErrorCode.NOT_FOUND));

        // 상점에 지역 추가
        store.setRegion(region);

        // 상점 저장
        storeRepository.save(store);

        // DTO로 반환
        return StoreConverter.toStoreDTO(store);
    }
}
