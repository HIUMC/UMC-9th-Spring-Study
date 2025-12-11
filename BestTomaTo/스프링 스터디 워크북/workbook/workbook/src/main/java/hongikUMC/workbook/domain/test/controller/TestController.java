package hongikUMC.workbook.domain.test.controller;

import hongikUMC.workbook.domain.test.converter.TestConverter;
import hongikUMC.workbook.domain.test.dto.res.TestResDTO;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import hongikUMC.workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() throws Exception{

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("it works!")
                );
    }
}
