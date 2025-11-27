package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.dto.MemberMissionResDTO;

public interface MemberMissionQueryService {

    // 내가 진행중인 미션 목록 조회
    MemberMissionResDTO.MemberMissionPreviewListDTO getMyInProgressMissions(Integer page);
}