package com.example.umcworkbook.dto.res;

import lombok.Builder;

public class MemberMissionResDto {

    @Builder
    public record PreviewDto(
            Integer point,
            String status,
            String restaurantName,
            Integer price
    ){}
}
