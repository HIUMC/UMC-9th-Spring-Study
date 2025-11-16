package com.example.umcworkbook.dto.res;

import java.time.LocalDateTime;
import lombok.Builder;

public class MemberResDto {

    @Builder
    public record JoinDto(
           Long memberId,
           LocalDateTime createAt
    ){}
}
