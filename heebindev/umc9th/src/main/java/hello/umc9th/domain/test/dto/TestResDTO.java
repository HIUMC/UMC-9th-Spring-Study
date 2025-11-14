package hello.umc9th.domain.test.dto;

import lombok.Builder;
import lombok.Getter;

public class TestResDTO {

    @Builder
    @Getter
    public static class Testing { //내부적인 static 클래스.
        private String testString; //워크북에서는 필드명을 testing
    }

    //TestErrorCode용 응답 dto
    @Builder
    @Getter
    public static class Exception{
        private String testString;
    }
}
