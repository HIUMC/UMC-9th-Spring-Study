package hello.umc9th.domain.test.converter;

import hello.umc9th.domain.test.dto.TestResDTO;
import org.springframework.http.HttpStatus;


public class TestConverter {
    //요청받은 객체를 응답 DTO로 변환
    public static TestResDTO.Testing toTestingDTO(String testing){
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    //TestErrorCode용 coverter
    public static TestResDTO.Exception toExceptionDTO(String testing){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }


}