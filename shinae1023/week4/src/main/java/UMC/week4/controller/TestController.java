package UMC.week4.controller;

import UMC.week4.dto.TestConverter;
import UMC.week4.dto.TestResDto;
import UMC.week4.global.apiPayload.ApiResponse;
import UMC.week4.global.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {
    @GetMapping("/test")
    public ApiResponse<TestResDto.Testing> test() throws Exception {
        return ApiResponse.onSuccess("조회 성공",TestConverter.toTestingDTO("This is Test!"));
    }

    @GetMapping("/exception")
    public ApiResponse<TestResDto.Exception> exception(
            @RequestParam Long flag
    ) {
        return ApiResponse.onSuccess("예외 테스트",TestConverter.toExceptionDTO("This is Test!"));
    }
}
