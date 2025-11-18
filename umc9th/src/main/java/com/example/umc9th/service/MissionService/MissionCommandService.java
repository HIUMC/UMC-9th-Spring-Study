package com.example.umc9th.service.MissionService;

import com.example.umc9th.domain.mission.entity.mapping.UserMission;

public interface MissionCommandService {
    UserMission challengeMission(Long missionId, Long memberId);
}