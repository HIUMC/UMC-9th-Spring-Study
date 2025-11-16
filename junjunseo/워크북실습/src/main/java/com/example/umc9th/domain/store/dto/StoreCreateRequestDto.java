package com.example.umc9th.domain.store.dto;

import com.example.umc9th.domain.store.enums.Region;
import lombok.Getter;

@Getter
public class StoreCreateRequestDto {
    private String name;
    private Long managerNumber;
    private String detailAddress;
    private Region region;
}
