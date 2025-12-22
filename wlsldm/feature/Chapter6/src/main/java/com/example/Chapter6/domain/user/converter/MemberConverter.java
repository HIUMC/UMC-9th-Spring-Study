package com.example.Chapter6.domain.user.converter;

import com.example.Chapter6.domain.mission.entity.Mission;
import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import com.example.Chapter6.domain.mission.enums.Complete;
import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.global.auth.enums.Role;

import java.util.Date;

public class MemberConverter {

    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreateAt())
                .build();
    }

    public static MemberResDTO.LoginDTO toLoginDTO(Member member, String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }

    public static Member toMember(
            MemberReqDTO.JoinDTO dto, String password, Role role
    ){
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .gender(dto.gender())
                .email(dto.email())
                .password(password)
                .role(role)
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
