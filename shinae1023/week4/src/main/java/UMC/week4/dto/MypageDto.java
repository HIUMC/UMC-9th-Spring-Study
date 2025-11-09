package UMC.week4.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MypageDto {
    private String nickname;
    private String email;
    private String phoneNum;
    private Integer point;
}
