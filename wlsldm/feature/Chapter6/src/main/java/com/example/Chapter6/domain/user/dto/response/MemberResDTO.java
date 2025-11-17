package com.example.Chapter6.domain.user.dto.response;

import com.example.Chapter6.domain.store.entity.Store;
import lombok.Builder;

import java.time.LocalDate;

public class MemberResDTO {

    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDate createAt
    ){}

    @Builder
    public record AddMissionDTO(
            Long memberId,
            Long missionId,
            String complete
    ){}
}
