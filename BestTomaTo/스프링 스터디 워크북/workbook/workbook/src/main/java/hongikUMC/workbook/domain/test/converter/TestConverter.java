package hongikUMC.workbook.domain.test.converter;

import hongikUMC.workbook.domain.test.dto.res.TestResDTO;

public class TestConverter {

    // 객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(
            String testing
    ){
        return TestResDTO.Testing.builder()
                .testing(testing)
                .build();
    }
}
