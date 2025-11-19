package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.dto.res.MemberMissionResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

public interface MemberMissionControllerDocs {

    @Operation(
            summary = "진행중인 미션 진행 완료로 바꾸기 API",
            description = "미션 상태를 성공으로 바꾸고 반환합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MemberMissionResDto.PreviewDto> updateMemberMission(
            @PathVariable Long memberMissionId
    );
}
