package hongikUMC.workbook.domain.mission.dto.req;

public class MissionReqDTO {

    public record saveMissionDTO(
            Long store_id,
            Long member_id,
            Long status,
            Long point
    ){}

    public record startMissionDTO(
        Long mission_id
    ){}
}
