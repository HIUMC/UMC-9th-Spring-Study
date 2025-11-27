package com.example.umc9th.domain.mission.service;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;

public interface MissionCommandService {
    UserMission challengeMission(Long missionId, Long memberId);
}
