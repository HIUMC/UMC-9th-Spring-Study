package com.example.Chapter6.domain.user.converter;

import com.example.Chapter6.domain.mission.entity.Mission;
import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import com.example.Chapter6.domain.mission.enums.Complete;
import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import com.example.Chapter6.domain.user.entity.Member;

import java.util.Date;

public class MemberConverter {

    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreateAt())
                .build();
    }

    public static Member toMember(
            MemberReqDTO.JoinDTO dto
    ){
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .gender(dto.gender())
                .email(dto.email())
                .phoneNum(dto.phoneNum())
                .build();
    }

    public static MemberResDTO.AddMissionDTO toAddMissionDTO(MissionMember missionMember) {
        return MemberResDTO.AddMissionDTO.builder()
                .missionId(missionMember.getMission().getId())
                .memberId(missionMember.getMember().getId())
                .complete(missionMember.getComplete().name())
                .build();
    }

    public static MissionMember toMissionMember(
            Mission mission, Member member
    ){
        return MissionMember.builder()
                .mission(mission)
                .member(member)
                .completeAt(new Date())
                .complete(Complete.FAILURE)
                .build();
    }

}
