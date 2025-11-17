package com.example.umcworkbook.service.command;

import com.example.umcworkbook.dto.res.MemberMissionResDto.searchDto;

public interface MemberMissionCommandService {

    searchDto createMemberMission(Long userId, Long missionId);
}
