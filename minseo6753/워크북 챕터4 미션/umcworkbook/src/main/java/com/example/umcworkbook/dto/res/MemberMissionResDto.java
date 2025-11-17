package com.example.umcworkbook.dto.res;

import lombok.Builder;

public class MemberMissionResDto {

    @Builder
    public record searchDto(
            Long memberMissionId
    ){}
}
