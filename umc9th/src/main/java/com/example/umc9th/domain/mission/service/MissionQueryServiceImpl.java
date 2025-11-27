package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final UserMissionRepository userMissionRepository;
    private final MemberRepository memberRepository; // Member를 조회하기 위해 추가

    @Override
    public MissionResponseDTO.ChallengingMissionListDTO getChallengingMissionList(Long memberId, Integer page) {

        // 1. 사용자 조회
        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // 2. 페이징 정보 생성
        // 클라이언트 페이지는 1부터, JPA 페이지는 0부터 시작하므로 1을 빼줍니다.
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 3. Repository를 통해 데이터 조회
        Page<UserMission> userMissionPage = userMissionRepository.findAllByMemberAndStatus(
                member,
                MissionStatus.CHALLENGING,
                pageRequest
        );

        // 4. Converter를 사용하여 DTO로 변환 후 반환
        return MissionConverter.toChallengingMissionListDTO(userMissionPage);
    }
}