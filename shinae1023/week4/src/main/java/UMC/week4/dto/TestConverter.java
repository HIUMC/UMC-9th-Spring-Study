package UMC.week4.dto;


public class TestConverter {
    public static TestResDto.Testing toTestingDTO(
            String testing
    ) {
        return TestResDto.Testing.builder()
                .testString(testing)
                .build();
    }

    public static TestResDto.Exception toExceptionDTO(
            String testing
    ){
        return TestResDto.Exception.builder()
                .testString(testing)
                .build();
    }
}
