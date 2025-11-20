package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.exception.MemberException;
import hello.umc9th.domain.member.exception.code.MemberErrorCode;
import hello.umc9th.domain.member.repository.MemberRepository;
import hello.umc9th.domain.mission.converter.MemberMissionConverter;
import hello.umc9th.domain.mission.dto.MemberMissionReqDTO;
import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.entity.Mission;
import hello.umc9th.domain.mission.exception.MissionException;
import hello.umc9th.domain.mission.exception.code.MissionErrorCode;
import hello.umc9th.domain.mission.repository.MemberMissionRepository;
import hello.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMissionResDTO.MemberMissionInfo createMemberMission(MemberMissionReqDTO.CreateMemberMissionDTO dto) {
        //에러도 새로 만들었따₩

        // 로그인 없는 관계로 임시 멤버
        final Long TEMP_MEMBER_ID = 1L;

        Member member = memberRepository.findById(TEMP_MEMBER_ID)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);

        MemberMission saved = memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toMemberMissionInfo(saved);
    }
}
