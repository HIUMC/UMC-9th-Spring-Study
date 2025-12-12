package hongikUMC.workbook.domain.member.dto.req;

import hongikUMC.workbook.domain.member.enums.Gender;
import hongikUMC.workbook.global.annotation.ExistFoods;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberReqDTO {

    // 자동으로 DTO형태를 만들어주는 신 타입
    // 회원가입 -> 멤버를 만듦.
    public record JoinDTO(
            String name,
            Gender gender,
            String socialID,
            String socialPW,
            String nickname,
            @ExistFoods
            List<Long> preferCategory
    ){}
}
