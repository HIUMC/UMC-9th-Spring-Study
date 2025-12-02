package UMC.week4.dto;

import UMC.week4.domain.Member;
import UMC.week4.domain.Store;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewRequestDto {
    private Member member;
    private Store store;
    private Integer star;
    private String content;
    private LocalDateTime createdAt;
}
