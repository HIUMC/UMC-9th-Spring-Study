package com.example.umcworkbook.service.command;

import com.example.umcworkbook.dto.res.MemberMissionResDto.PreviewDto;

public interface MemberMissionCommandService {

    PreviewDto createMemberMission(Long userId, Long missionId);
}
