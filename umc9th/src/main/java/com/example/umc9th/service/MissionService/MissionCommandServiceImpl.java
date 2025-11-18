package com.example.umc9th.service.MissionService;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMission challengeMission(Long missionId, Long memberId) {
        // 1. 미션과 사용자 엔티티를 조회합니다.
        //    - orElseThrow: 조회가 안 되면 지정된 예외를 발생시킵니다.
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // 2. 이미 도전 중인 미션인지 확인합니다.
        if (userMissionRepository.existsByMemberAndMission(member, mission)) {
            throw new GeneralException(ErrorStatus.MISSION_ALREADY_CHALLENGING);
        }

        // 3. 컨버터를 사용하여 UserMission 엔티티를 생성합니다.
        UserMission userMission = MissionConverter.toUserMission(mission, member);

        // 4. 생성된 UserMission을 저장하고 반환합니다.
        return userMissionRepository.save(userMission);
    }
}