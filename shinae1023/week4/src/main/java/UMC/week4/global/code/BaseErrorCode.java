package UMC.week4.global.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();

}
