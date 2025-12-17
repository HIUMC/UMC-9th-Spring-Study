package hongikUMC.workbook.domain.store.converter;

import hongikUMC.workbook.domain.store.dto.req.StoreReqDTO;
import hongikUMC.workbook.domain.store.dto.res.StoreResDTO;
import hongikUMC.workbook.domain.store.entity.Store;

public class StoreConverter {

    // 객체 - > DTO
    public static StoreResDTO.saveStoreDTO toStoreDTO(
            Store store
    ){
        return StoreResDTO.saveStoreDTO.builder()
                .store_id(store.getStore_id())
                .created_at(store.getCreated_at())
                .build();
    }

    // DTO -> 객체
    // region은 바로 들어갈 수 없기에 Service 계층에서 처리
    public static Store toStore(
            StoreReqDTO.saveStoreDTO dto
    ){
        return Store.builder()
                .name(dto.name())
                .field(dto.field())
                .build();
    }
}
