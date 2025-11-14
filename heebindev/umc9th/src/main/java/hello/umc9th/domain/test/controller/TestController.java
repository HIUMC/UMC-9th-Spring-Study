//package hello.umc9th.domain.test.controller;
//
//import hello.umc9th.domain.test.converter.TestConverter;
//import hello.umc9th.domain.test.dto.TestResDTO;
//import hello.umc9th.domain.test.exception.TestException;
//import hello.umc9th.global.apiPayload.ApiResponse;
//import hello.umc9th.global.apiPayload.code.GeneralErrorCode;
//import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/temp")
//public class TestController {
//    @GetMapping("/test")
//    public ApiResponse<TestResDTO.Testing> test() throws Exception {
//        // 응답 코드 정의
//        GeneralSuccessCode code = GeneralSuccessCode.OK;
//        throw new TestException(GeneralErrorCode.INTERNAL_SERVER_ERROR);
//        return ApiResponse.onSuccess(
//                GeneralSuccessCode.OK,
//                TestConverter.toTestDTO("This is Test!")
//        );
//    }
//}
