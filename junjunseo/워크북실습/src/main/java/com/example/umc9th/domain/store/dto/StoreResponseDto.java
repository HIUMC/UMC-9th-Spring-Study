package com.example.umc9th.domain.store.dto;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.Region;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponseDto {

    private Long id;
    private String name;
    private Long managerNumber;
    private String detailAddress;
    private Region region;

    public static StoreResponseDto from(Store store) {
        return StoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .managerNumber(store.getManagerNumber())
                .detailAddress(store.getDetailAddress())
                .region(store.getRegion())
                .build();
    }
}
