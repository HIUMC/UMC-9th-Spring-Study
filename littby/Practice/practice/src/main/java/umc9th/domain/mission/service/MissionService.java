package umc9th.domain.mission.service;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc9th.domain.member.entity.Member;
import umc9th.domain.member.repository.memberRepository;
import umc9th.domain.mission.converter.MissionConverter;
import umc9th.domain.mission.dto.MissionRequestDTO;
import umc9th.domain.mission.dto.MissionResponseDTO;
import umc9th.domain.mission.entity.Mission;
import umc9th.domain.mission.entity.UserMission;
import umc9th.domain.mission.repository.MissionRepository;
import umc9th.domain.store.entity.Restaurant;
import umc9th.global.apiPayload.code.GeneralErrorCode;
import umc9th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public UserMission createChallenge(MissionRequestDTO.ChallengeMissionDTO request) {


        User user = userRepository.findById(1L).orElseThrow(() ->
                new GeneralException(GeneralErrorCode.MEMBER_NOT_FOUND));


        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() ->
                new GeneralException(GeneralErrorCode.MISSION_NOT_FOUND));

        UserMission newUserMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.PROGRESS)
                .build();


        return userMissionRepository.save(newUserMission);
    }

    public MissionResponseDTO.MissionListDTO getRestaurantMissions(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.RESTAURANT_NOT_FOUND));

        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));

        return MissionConverter.toMissionListDTO(missionPage);
    }
    public MissionResponseDTO.MissionListDTO getMyOngoingMissions(Integer page) {


        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.MEMBER_NOT_FOUND));

        Page<UserMission> userMissionPage = userMissionRepository.findAllByMemberAndStatus(
                member, MissionStatus.PROGRESS, PageRequest.of(page, 10)
        );

        return MissionConverter.MissionListDTO(userMissionPage);
    }
}