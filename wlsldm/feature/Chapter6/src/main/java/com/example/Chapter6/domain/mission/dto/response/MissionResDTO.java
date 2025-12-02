package com.example.Chapter6.domain.mission.dto.response;

import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class MissionResDTO {
    @Builder
    public record MissionPreViewListDTO(
            List<MissionResDTO.MissionPreViewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MissionPreViewDTO(
           String name,
           Date expiredAt,
           String content,
           Integer point,
           String storeName
    ){}
}
