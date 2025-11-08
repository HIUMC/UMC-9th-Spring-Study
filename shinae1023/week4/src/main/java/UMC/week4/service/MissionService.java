package UMC.week4.service;

import UMC.week4.domain.Member;
import UMC.week4.domain.enums.MissionStatus;
import UMC.week4.domain.enums.Region;
import UMC.week4.dto.MissionStatsDto;
import UMC.week4.repository.MemberRepository;
import UMC.week4.repository.MissionRepository;
import UMC.week4.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

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
                .build();
    }
}
