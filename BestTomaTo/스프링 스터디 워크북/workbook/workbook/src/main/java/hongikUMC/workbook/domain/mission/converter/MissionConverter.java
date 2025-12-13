package hongikUMC.workbook.domain.mission.converter;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.mission.dto.req.MissionReqDTO;
import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.entity.Mission;
import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;

public class MissionConverter {

    // 객체 -> DTO
    public static MissionResDTO.saveMissionDTO toMissionDTO(
            Mission mission
    ){
        return MissionResDTO.saveMissionDTO.builder()
                .mission_id(mission.getMission_id())
                .created_at(mission.getCreated_at())
                .build();
    }

    public static MissionResDTO.startMissionDTO tostartMissionDTO(
        Mission mission
    ){
        return MissionResDTO.startMissionDTO.builder()
                .mission_id(mission.getMission_id())
                .status(mission.getStatus())
                .updated_at(mission.getUpdated_at())
                .build();
    }

    // DTO -> 객체
    public static Mission toMission(
            MissionReqDTO.saveMissionDTO dto
    ){
        return Mission.builder()
                .point(dto.point())
                .build();
    }

    public static MemberMission toMemberMission(
            Member member,
            Mission mission
    ){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
