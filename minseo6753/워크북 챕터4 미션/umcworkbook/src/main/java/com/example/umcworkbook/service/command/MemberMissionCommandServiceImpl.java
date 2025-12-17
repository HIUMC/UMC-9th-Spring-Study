package com.example.umcworkbook.service.command;

import com.example.umcworkbook.apiPayload.code.error.MemberErrorCode;
import com.example.umcworkbook.apiPayload.code.error.MemberMissionErrorCode;
import com.example.umcworkbook.apiPayload.code.error.MissionErrorCode;
import com.example.umcworkbook.apiPayload.exception.MemberException;
import com.example.umcworkbook.apiPayload.exception.MemberMissionException;
import com.example.umcworkbook.apiPayload.exception.MissionException;
import com.example.umcworkbook.converter.MemberMissionConverter;
import com.example.umcworkbook.dto.res.MemberMissionResDto;
import com.example.umcworkbook.entity.Member;
import com.example.umcworkbook.entity.MemberMission;
import com.example.umcworkbook.entity.Mission;
import com.example.umcworkbook.entity.enums.MissionStatus;
import com.example.umcworkbook.repository.MemberMissionRepository;
import com.example.umcworkbook.repository.MemberRepository;
import com.example.umcworkbook.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResDto.PreviewDto createMemberMission(Long memberId, Long missionId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberException(MemberErrorCode.NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new MissionException(MissionErrorCode.NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.ONGOING)
                .build();

        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toPreviewDto(memberMission);
    }

    @Override
    public MemberMissionResDto.PreviewDto completeMemberMission(
            Long memberMissionId
    ) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MemberMissionException(MemberMissionErrorCode.NOT_FOUND));

        memberMission.complete();

        return MemberMissionConverter.toPreviewDto(memberMission);
    }
}
