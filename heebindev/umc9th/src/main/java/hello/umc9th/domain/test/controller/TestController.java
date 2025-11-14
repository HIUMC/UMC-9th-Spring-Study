package hello.umc9th.domain.test.controller;

import hello.umc9th.domain.test.converter.TestConverter;
import hello.umc9th.domain.test.dto.TestResDTO;
import hello.umc9th.domain.test.exception.TestException;
import hello.umc9th.domain.test.service.query.TestQueryService;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralErrorCode;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //생성자 생성
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() throws Exception {

        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK; //enum을 ok로
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("This is Test!")
        );
    }

    //예외 상황 TestErrorCode용
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.Exception> exception(@RequestParam Long flag){
        testQueryService.checkFlag(flag);

        //응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDTO("This is Test!"));
    }
}
