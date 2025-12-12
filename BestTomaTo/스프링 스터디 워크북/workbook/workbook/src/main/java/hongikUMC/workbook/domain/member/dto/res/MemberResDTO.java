package hongikUMC.workbook.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {

    // 회원가입 -> ID와 생성일짜 반환
    /**
     * 리포지토리 계층에서 생성된 엔티티를 담을 DTO니 Builder 패턴으로 생성하자!
     * */
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createdAt
    ){}
}
