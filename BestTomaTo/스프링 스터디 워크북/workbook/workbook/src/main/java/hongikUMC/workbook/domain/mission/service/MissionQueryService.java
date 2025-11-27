package hongikUMC.workbook.domain.mission.service;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.domain.mission.converter.MissionConverter;
import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.entity.Mission;
import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;
import hongikUMC.workbook.domain.mission.repository.MemberMissionRepository;
import hongikUMC.workbook.domain.mission.repository.MissionRepository;
import hongikUMC.workbook.domain.store.entity.Store;
import hongikUMC.workbook.domain.store.repository.StoreRepository;
import hongikUMC.workbook.global.apiPayload.code.GeneralErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public MissionResDTO.MissionListDTO getMissionByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);
        return MissionConverter.toMissionListDTO(result);
    }

    public MissionResDTO.MemberMissionListDTO getMissionByMember(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<MemberMission> result = memberMissionRepository.findAllByMember(member, pageRequest);
        return MissionConverter.toMemberMissionListDTO(result);
    }
}
