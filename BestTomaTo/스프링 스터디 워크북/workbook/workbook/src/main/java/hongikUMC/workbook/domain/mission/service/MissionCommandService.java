package hongikUMC.workbook.domain.mission.service;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.exception.MemberException;
import hongikUMC.workbook.domain.member.exception.code.MemberErrorCode;
import hongikUMC.workbook.domain.mission.entity.mapped.MemberMission;
import hongikUMC.workbook.domain.mission.enums.Status;
import hongikUMC.workbook.domain.mission.exception.MissionException;
import hongikUMC.workbook.domain.mission.exception.code.MissionErrorCode;
import hongikUMC.workbook.domain.mission.repository.MemberMissionRepository;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.domain.mission.converter.MissionConverter;
import hongikUMC.workbook.domain.mission.dto.req.MissionReqDTO;
import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.entity.Mission;
import hongikUMC.workbook.domain.mission.repository.MissionRepository;
import hongikUMC.workbook.domain.store.entity.Store;
import hongikUMC.workbook.domain.store.exception.StoreException;
import hongikUMC.workbook.domain.store.exception.code.StoreErrorCode;
import hongikUMC.workbook.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    // 미션 생성
    /**
     * 해야할 일
     * 1. 미션 엔티티에 상점 정보 넣기 // 상점 처리 불필요
     * 2. 미션 엔티티 정보 넣기
     * 3. 멤버 - 미션 튜플 제작
     * */
    @Transactional
    public MissionResDTO.saveMissionDTO saveMission(
            MissionReqDTO.saveMissionDTO missionDTO
    ) {
        // 미션 엔티티 생성
        Mission mission = MissionConverter.toMission(missionDTO);

        // 미션 status
        Status status = Status.STBY;
        status = switch (missionDTO.status().intValue()) {
            case 1 -> Status.ING;
            case 2 -> Status.END;
            default -> status;
        };
        mission.setStatus(status);

        // 상점 불러와서 미션에 넣기
        Store store = storeRepository.findById(missionDTO.store_id())
                .orElseThrow(() -> new StoreException(StoreErrorCode.BAD_REQUEST));

        mission.setStore(store);

        // 미션 저장
        missionRepository.save(mission);

        // 멤버-미션 튜플 생성
        Member member = memberRepository.findById(missionDTO.member_id())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        MemberMission memberMission = MissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);

        // 미션 DTO 반환
        return MissionConverter.toMissionDTO(mission);
    }

    // 도전 미션 생성
    @Transactional
    public MissionResDTO.startMissionDTO addStartMission(
            MissionReqDTO.startMissionDTO startMissionDTO
    ){
        // status를 도전으로 변경
        Mission mission = missionRepository.findById(startMissionDTO.mission_id())
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        mission.setStatus(Status.ING);
        missionRepository.save(mission);

        // 미션 DTO 반환
        return MissionConverter.tostartMissionDTO(mission);
    }
}
