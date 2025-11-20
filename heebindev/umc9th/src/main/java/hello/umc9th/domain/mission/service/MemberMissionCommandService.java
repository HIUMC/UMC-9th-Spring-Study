package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.dto.MemberMissionReqDTO;
import hello.umc9th.domain.mission.dto.MemberMissionResDTO;

public interface MemberMissionCommandService {
    MemberMissionResDTO.MemberMissionInfo createMemberMission(MemberMissionReqDTO.CreateMemberMissionDTO dto);
}
