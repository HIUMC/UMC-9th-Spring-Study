package hongikUMC.workbook.domain.test.controller;

import hongikUMC.workbook.domain.test.converter.TestConverter;
import hongikUMC.workbook.domain.test.dto.res.TestResDTO;
import hongikUMC.workbook.domain.test.exception.TestException;
import hongikUMC.workbook.domain.test.service.query.TestQueryService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import hongikUMC.workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() throws Exception{

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("it works!")
                );
    }

    // 예외 상황
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.Exception> exception(
            @RequestParam Long flag
    ) {
        testQueryService.checkFlag(flag);

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                TestConverter.toExceptionDTO("it works!")
                );
    }
}
