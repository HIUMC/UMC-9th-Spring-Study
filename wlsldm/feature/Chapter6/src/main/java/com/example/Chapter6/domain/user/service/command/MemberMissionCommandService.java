package com.example.Chapter6.domain.user.service.command;

import com.example.Chapter6.domain.mission.entity.Mission;
import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import com.example.Chapter6.domain.mission.enums.Complete;
import com.example.Chapter6.domain.mission.repository.MissionMemberRepository;
import com.example.Chapter6.domain.mission.repository.MissionRepository;
import com.example.Chapter6.domain.user.converter.MemberConverter;
import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MissionMemberRepository missionMemberRepository;

    public MemberResDTO.AddMissionDTO addMission(MemberReqDTO.AddMissionDTO dto) {

        Mission mission = missionRepository.findById(dto.missionId())
                .orElseThrow(() -> new RuntimeException("미션이 존재하지 않습니다"));

        Member member = memberRepository.findById(dto.memberId())
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다"));


        MissionMember addMission = MemberConverter.toMissionMember(mission, member);

        MissionMember saved = missionMemberRepository.save(addMission);

        return MemberConverter.toAddMissionDTO(saved);
    }



}
