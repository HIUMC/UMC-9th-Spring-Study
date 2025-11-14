package hello.umc9th.domain.test.converter;

import hello.umc9th.domain.test.dto.TestResDTO;
import org.aspectj.weaver.ast.Test;

public class TestConverter {

    //객체 -> DTO
    public static TestResDTO.Testing toTestDTO(String testing) {
        return TestResDTO.Testing.builder()
                .testing(testing)
                .build();
    }

    //객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(String testing) {
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}