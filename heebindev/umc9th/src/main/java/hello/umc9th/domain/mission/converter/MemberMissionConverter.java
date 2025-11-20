package hello.umc9th.domain.mission.converter;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.mission.dto.MemberMissionReqDTO;
import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.entity.Mission;

public class MemberMissionConverter {

    // DTO → Entity
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    // Entity → DTO
    public static MemberMissionResDTO.MemberMissionInfo toMemberMissionInfo(MemberMission entity) {
        return MemberMissionResDTO.MemberMissionInfo.builder()
                .id(entity.getId())
                .memberName(entity.getMember().getName())
                .missionContent(entity.getMission().getMissionContent())
                .status(entity.getMissionStatus().name())
                .build();
    }
}