package umc9th.domain.mission.service;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc9th.domain.mission.dto.MissionRequestDTO;
import umc9th.domain.mission.entity.Mission;
import umc9th.domain.mission.entity.UserMission;
import umc9th.domain.mission.repository.MissionRepository;
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
}