package hongikUMC.workbook.domain.mission.controller;

import hongikUMC.workbook.domain.mission.dto.req.MissionReqDTO;
import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.exception.code.MissionSuccessCode;
import hongikUMC.workbook.domain.mission.service.MissionCommandService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 미션 추가
    @PostMapping("/add")
    public ApiResponse<MissionResDTO.saveMissionDTO> saveMission(
            @RequestBody MissionReqDTO.saveMissionDTO missionDTO
    ){
        return ApiResponse.onSuccess(MissionSuccessCode.OK, missionCommandService.saveMission(missionDTO));
    }

    // 진행 중인 미션으로 변경
    @PutMapping("/add/ing")
    public ApiResponse<MissionResDTO.startMissionDTO> startMission(
            @RequestBody MissionReqDTO.startMissionDTO missionDTO
    ){
        return ApiResponse.onSuccess(MissionSuccessCode.OK, missionCommandService.addStartMission(missionDTO));
    }
}
