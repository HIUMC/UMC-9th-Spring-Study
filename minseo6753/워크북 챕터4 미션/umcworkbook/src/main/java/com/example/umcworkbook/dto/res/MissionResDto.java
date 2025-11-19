package com.example.umcworkbook.dto.res;

import java.util.List;
import lombok.Builder;

public class MissionResDto {

    @Builder
    public record PreviewDto(
            String restaurantName,
            String category,
            Integer price,
            Integer point,
            Integer days_left
    ){}

    @Builder
    public record PreviewListDto(
            List<MissionResDto.PreviewDto> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
