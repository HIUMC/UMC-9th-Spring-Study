package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.success.GeneralSuccessCode;
import com.example.umcworkbook.dto.res.MissionResDto;
import com.example.umcworkbook.service.query.MissionQueryService;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionController implements MissionControllerDocs{

    private final MissionQueryService missionQueryService;

    public MissionController(MissionQueryService missionQueryService) {
        this.missionQueryService = missionQueryService;
    }

    @GetMapping("/restaurants/{restaurantId}/missions")
    @Override
    public ApiResponse<MissionResDto.PreviewListDto> getRestaurantMissions(
            @PathVariable Long restaurantId,
            @RequestParam(defaultValue = "1") @Positive Integer page
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                missionQueryService.findRestaurantMissions(restaurantId, page - 1)
        );
    }
}
