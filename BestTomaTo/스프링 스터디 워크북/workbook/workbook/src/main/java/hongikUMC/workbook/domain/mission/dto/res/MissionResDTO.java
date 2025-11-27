package hongikUMC.workbook.domain.mission.dto.res;

import hongikUMC.workbook.domain.mission.enums.Status;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import lombok.Builder;

import java.util.List;

public class MissionResDTO {

    @Builder
    public static record MissionDTO(
            Long mission_id,
            Status status) {}

    @Builder
    public static record MissionListDTO (
            List<MissionResDTO.MissionDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public static record MemberMissionDTO(
            Long memberId,
            Long missionId) {}

    @Builder
    public static record MemberMissionListDTO (
            List<MissionResDTO.MemberMissionDTO> memberMissionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
