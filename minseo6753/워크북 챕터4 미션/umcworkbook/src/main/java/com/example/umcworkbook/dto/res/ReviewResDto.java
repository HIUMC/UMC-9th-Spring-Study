package com.example.umcworkbook.dto.res;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

public class ReviewResDto {

    @Builder
    public record MyReviewDto(
            Long reviewId,
            Float star,
            String content
    ){}

    @Builder
    public record PreviewDto(
            String memberNickName,
            Float star,
            String content,
            LocalDate createdAt
    ){}

    @Builder
    public record PreviewListDto(
            List<PreviewDto> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
