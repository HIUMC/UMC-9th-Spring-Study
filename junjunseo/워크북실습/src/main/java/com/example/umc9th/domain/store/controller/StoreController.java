package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.StoreResponseDto;
import com.example.umc9th.domain.store.enums.Region;
import com.example.umc9th.domain.store.service.StoreService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * StoreController
 * - 가게 검색 API
 * - 필터링(지역), 이름 검색, 정렬, 페이징 지원
 */
@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public ApiResponse<Page<StoreResponseDto>> getStores(
            @RequestParam(required = false) List<String> region, // 문자열로 받아서 변환
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "latest") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<Region> regionEnums = null;
        if (region != null && !region.isEmpty()) {
            regionEnums = region.stream()
                    .map(r -> Region.valueOf(r.toUpperCase()))  // String → Enum
                    .toList();
        }

        Page<StoreResponseDto> stores = storeService.searchStores(regionEnums, keyword, sort, page, size);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                stores
        );
    }
}