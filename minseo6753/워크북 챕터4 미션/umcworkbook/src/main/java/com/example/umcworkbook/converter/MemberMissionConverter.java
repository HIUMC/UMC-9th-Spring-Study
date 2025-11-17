package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.MemberMissionResDto;
import com.example.umcworkbook.entity.MemberMission;

public class MemberMissionConverter {

    public static MemberMissionResDto.searchDto toSearchDto(
            MemberMission memberMission
    ) {
        return MemberMissionResDto.searchDto.builder()
                .memberMissionId(memberMission.getId())
                .build();
    }
}
