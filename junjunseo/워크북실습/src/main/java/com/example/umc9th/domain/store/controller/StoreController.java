package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.service.MissionQueryService;
import com.example.umc9th.domain.store.dto.StoreReqDto;
import com.example.umc9th.domain.store.dto.StoreResDto;
import com.example.umc9th.domain.store.enums.Region;
import com.example.umc9th.domain.store.service.StoreService;
import com.example.umc9th.global.annotation.PageParam;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    private final MissionQueryService missionQueryService;

    @GetMapping
    public ApiResponse<Page<StoreResDto>> getStores(
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

        Page<StoreResDto> stores = storeService.searchStores(regionEnums, keyword, sort, page, size);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                stores
        );
    }

    @PostMapping
    public ApiResponse<StoreResDto> createStore(@RequestBody StoreReqDto request) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, storeService.createStore(request));
    }

    @Operation(
            summary = "특정 가게의 미션 목록 조회",
            description = """
                    특정 가게(storeId)의 미션 목록을 페이징(10개씩)으로 조회합니다.
                    - page는 1부터 시작합니다.
                    """
    )
    @GetMapping("/{storeId}/missions")
    public Page<MissionResDto.StoreMissionDto> getStoreMissions(
            @Parameter(description = "가게 ID", example = "1")
            @PathVariable Long storeId,
            @Parameter(description = "페이지 번호 (1부터 시작)", example = "1")
            @PageParam Integer page
    ) {
        return missionQueryService.getStoreMissions(storeId, page);
    }
}