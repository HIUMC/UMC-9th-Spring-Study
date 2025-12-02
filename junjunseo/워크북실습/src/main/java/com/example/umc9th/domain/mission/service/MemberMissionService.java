package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    public MemberMissionResDto challenge(MemberMissionReqDto req) {

        Mission mission = missionRepository.findById(req.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 미션이 존재하지 않습니다."));

        // 로그인 없음 → memberId = 1L 고정
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("임시 멤버(1L)가 존재하지 않습니다."));

        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .isComplete(false)
                .build();

        MemberMission saved = memberMissionRepository.save(memberMission);

        return MissionConverter.toMemberMissionResDto(saved);
    }
}
