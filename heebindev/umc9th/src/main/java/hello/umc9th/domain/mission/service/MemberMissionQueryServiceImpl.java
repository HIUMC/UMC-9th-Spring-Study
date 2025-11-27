package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.converter.MemberMissionConverter;
import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.enums.Status;
import hello.umc9th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResDTO.MemberMissionPreviewListDTO getMyInProgressMissions(Integer page) {

        // 로그인 기능이 없으므로 1번 회원으로 고정
        final Long TEMP_MEMBER_ID = 1L;

        // 페이지 설정 (한 페이지에 10개)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 진행중(IN_PROGRESS) 인 미션만 조회
        Page<MemberMission> result =
                memberMissionRepository.findAllByMemberIdAndMissionStatus(
                        TEMP_MEMBER_ID,
                        Status.IN_PROGRESS,
                        pageRequest
                );

        // Page<MemberMission> → DTO 변환
        return MemberMissionConverter.toMemberMissionPreviewListDTO(result);
    }
}