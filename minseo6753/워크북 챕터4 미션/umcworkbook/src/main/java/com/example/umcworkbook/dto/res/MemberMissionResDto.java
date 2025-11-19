package com.example.umcworkbook.dto.res;

import java.util.List;
import lombok.Builder;

public class MemberMissionResDto {

    @Builder
    public record PreviewDto(
            Integer point,
            String status,
            String restaurantName,
            Integer price
    ){}

    @Builder
    public record PreviewListDto(
            List<MemberMissionResDto.PreviewDto> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
