package hello.umc9th.domain.mission.converter;

import hello.umc9th.domain.mission.dto.MissionResDTO;
import hello.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    // Mission 엔티티 → MissionPreviewDTO
    public static MissionResDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .missionContent(mission.getMissionContent())
                .point(mission.getPoint())
                .missionDeadline(mission.getMissionDeadline())
                .build();
    }

    // Page<Mission> → MissionPreviewListDTO
    public static MissionResDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> result) {
        return MissionResDTO.MissionPreviewListDTO.builder()
                .missionList(
                        result.getContent().stream()
                                .map(MissionConverter::toMissionPreviewDTO)
                                .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
}