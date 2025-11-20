package hello.umc9th.domain.store.dto;

public class StoreReqDTO {

    // 특정 지역에 가게 추가 요청 DTO
    public static class CreateStoreDTO {
        public String name;
        public String address;
        public String location; // Enum String (SEOUL, INCHEON 등)
    }
}