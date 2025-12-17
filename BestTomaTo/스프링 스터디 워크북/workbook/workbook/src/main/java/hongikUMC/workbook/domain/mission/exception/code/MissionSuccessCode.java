package hongikUMC.workbook.domain.mission.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "MISSION200", "미션 생성이 완료되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
