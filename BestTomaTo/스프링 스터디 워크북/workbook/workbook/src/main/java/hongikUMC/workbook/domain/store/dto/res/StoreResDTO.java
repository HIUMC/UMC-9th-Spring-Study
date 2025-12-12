package hongikUMC.workbook.domain.store.dto.res;

import lombok.Builder;
import java.time.LocalDateTime;

public class StoreResDTO {

    @Builder
    public record saveStoreDTO(
            Long store_id,
            LocalDateTime created_at
    ){}
}
