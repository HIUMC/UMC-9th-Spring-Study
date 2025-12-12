package hongikUMC.workbook.domain.store.dto.req;

public class StoreReqDTO {

    public record saveStoreDTO(
            Long region,
            String name,
            String field
    ){}
}
