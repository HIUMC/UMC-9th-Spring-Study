package hongikUMC.workbook.domain.mission.converter;

import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.entity.Mission;
import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;
import org.springframework.data.domain.Page;

public class MissionConverter {
    /**
     * Mission 엔티티 하나를 MissionDTO로 변환하는 메소드
     */
    public static MissionResDTO.MissionDTO toMissionDTO(
            Mission mission
    ) {
        return MissionResDTO.MissionDTO.builder()
                .mission_id(mission.getMission_id())
                .status(mission.getStatus())
                .build();
    }

    /**
     * Review 엔티티 리스트를 ReviewListDTO로 변환하는 메소드
     */
    public static MissionResDTO.MissionListDTO toMissionListDTO(
            Page<Mission> missionList
    ) {
        return MissionResDTO.MissionListDTO.builder()
                .missionList(missionList.getContent().stream()
                        .map(MissionConverter::toMissionDTO)
                        .toList()
                )
                .listSize(missionList.getSize())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();
    }

    /**
     * Mission 엔티티 하나를 MissionDTO로 변환하는 메소드
     */
    public static MissionResDTO.MemberMissionDTO toMemberMissionDTO(
            MemberMission memberMission
    ) {
        return MissionResDTO.MemberMissionDTO.builder()
                .memberId(memberMission.getMember_mission_id())
                .missionId(memberMission.getMember_mission_id())
                .build();
    }

    /**
     * Review 엔티티 리스트를 ReviewListDTO로 변환하는 메소드
     */
    public static MissionResDTO.MemberMissionListDTO toMemberMissionListDTO(
            Page<MemberMission> memberMissionList
    ) {
        return MissionResDTO.MemberMissionListDTO.builder()
                .memberMissionList(memberMissionList.getContent().stream()
                        .map(MissionConverter::toMemberMissionDTO)
                        .toList()
                )
                .listSize(memberMissionList.getSize())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .build();
    }
}
