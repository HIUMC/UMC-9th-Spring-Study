package UMC.week4.service;

import UMC.week4.converter.MissionConverter;
import UMC.week4.domain.Member;
import UMC.week4.domain.Mission;
import UMC.week4.domain.Store;
import UMC.week4.domain.UserMission;
import UMC.week4.domain.enums.MissionStatus;
import UMC.week4.domain.enums.Region;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionStatsDto;
import UMC.week4.global.code.GeneralErrorCode;
import UMC.week4.global.exception.GeneralException;
import UMC.week4.repository.MemberRepository;
import UMC.week4.repository.MissionRepository;
import UMC.week4.repository.StoreRepository;
import UMC.week4.repository.UserMissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final StoreRepository storeRepository;

    public MissionStatsDto getMissionStats(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Region userRegion = member.getRegion();

        long totalMissions = missionRepository.countByStore_Region(userRegion);
        long completedMissions = userMissionRepository.countByMember_IdAndMission_Store_RegionAndIsComplete(
                memberId, userRegion, MissionStatus.COMPLETED
        );

        return MissionStatsDto.builder()
                .totalMissions(totalMissions)
                .completedMissions(completedMissions)
                .build();}

    /**
     * API 1: 가게의 미션을 도전중인 미션에 추가
     */
    @Transactional
    public UserMission challengeMission(Long memberId, Long missionId) {
        // 1. 회원과 미션 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.MISSION_NOT_FOUND));

        // 2. UserMission 생성 (Converter 활용)
        UserMission newUserMission = MissionConverter.toUserMission(mission);

        // 3. 연관관계 설정
        newUserMission.setMember(member);

        // 4. 저장 및 반환
        return userMissionRepository.save(newUserMission);
    }

    /**
     * API 2: 가게에 미션 추가하기
     */
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDto.CreateMissionDto request) {
        // 1. 가게 엔티티 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.STORE_NOT_FOUND));

        // 2. DTO -> Entity 변환 (Converter 활용)
        Mission newMission = MissionConverter.toMission(request);

        // 3. 연관관계 설정
        newMission.setStore(store);

        // 4. 저장 및 반환
        return missionRepository.save(newMission);
    }
}
