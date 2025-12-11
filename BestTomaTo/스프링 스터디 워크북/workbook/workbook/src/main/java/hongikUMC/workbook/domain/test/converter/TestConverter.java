package hongikUMC.workbook.domain.test.converter;

import hongikUMC.workbook.domain.test.dto.res.TestResDTO;

public class TestConverter {

    // 객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(
            String testing
    ){
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    // 객체 -> DTO (예외)
    // 여기서 위와 모양이 같지만 아예 다르게 설계할 수 있다.
    public static TestResDTO.Exception toExceptionDTO(
        String testing
    ){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
