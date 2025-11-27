package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.dto.MissionResDTO;

public interface MissionQueryService {
    //특정 가게의 미션 목록 조회!
    MissionResDTO.MissionPreviewListDTO getMissionsByStore(Long storeId, Integer page);

}
