package com.example.umc9th.domain.test.controller;

import com.example.umc9th.domain.test.converter.TestConverter;
import com.example.umc9th.domain.test.dto.TestDTO;
import com.example.umc9th.domain.test.exception.TestException;
import com.example.umc9th.domain.test.exception.code.TestErrorCode;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.status.SuccessStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestRestController는 테스트용 API 엔드포인트를 제공합니다.
 *
 * @author shinwook.kang
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestRestController {

    /**
     * 임시 test API
     * <p>
     * 클라이언트로부터 쿼리 스트링으로 testString과 testInteger를 받아,
     * 이를 포함하는 성공 응답을 반환합니다.
     *
     * @param testString  쿼리 스트링으로 받을 테스트 문자열 (예: /test/?testString=hello)
     * @param testInteger 쿼리 스트링으로 받을 테스트 정수 (예: &testInteger=123)
     * @return ApiResponse<TestDTO.TestResponseDTO> 형태의 JSON 응답
     */
    @GetMapping("/")
    public ApiResponse<TestDTO.TestResponseDTO> test(
            @RequestParam(name = "testString") String testString,
            @RequestParam(name = "testInteger") Integer testInteger
    ) {
        // 1. TestConverter를 사용하여 요청 파라미터를 응답 DTO로 변환합니다.
        TestDTO.TestResponseDTO responseDTO = TestConverter.toTestResponseDTO(testString, testInteger);

        // 2. ApiResponse.onSuccess를 사용하여 최종적인 성공 응답 객체를 생성합니다.
        return ApiResponse.onSuccess(responseDTO);
    }

    /**
     * 예외 처리 테스트 API
     * <p>
     * 'flag' 쿼리 스트링 파라미터가 1일 경우, 정의된 예외(TestException)를 발생시킵니다.
     *
     * @param flag 쿼리 스트링으로 받을 플래그 (예: /test/exception?flag=1)
     * @return 'flag'가 1이 아닐 경우, 성공 응답을 반환합니다.
     */
    @GetMapping("/exception")
    public ApiResponse<TestDTO.TestResponseDTO> exceptionTest(@RequestParam(name = "flag") Integer flag) {
        if (flag == 1) {
            // 'flag'가 1이면, 정의해둔 TestException을 발생시킵니다.
            throw new TestException(TestErrorCode.FLAG_ONE_ERROR);
        }

        // 'flag'가 1이 아니면, 임의의 성공 응답을 반환합니다.
        return ApiResponse.onSuccess(TestConverter.toTestResponseDTO("Success!", 200));
    }

    /**
     * 생성 성공(201 Created) 응답 테스트 API
     * <p>
     * POST 요청 본문으로 받은 데이터를 사용하여,
     * 201 상태 코드와 함께 성공 응답을 반환합니다.
     *
     * @param request 요청 본문에 담길 JSON 데이터 (TestRequestDTO)
     * @return ApiResponse<TestDTO.TestResponseDTO> 형태의 JSON 응답
     */
    @PostMapping("/created")
    public ApiResponse<TestDTO.TestResponseDTO> createTest(@RequestBody TestDTO.TestRequestDTO request) {
        // 요청 받은 name으로 응답 DTO를 생성
        TestDTO.TestResponseDTO responseDTO = TestConverter.toTestResponseDTO("Created: " + request.getName(), 1);

        // ApiResponse.of를 사용하여 201 Created 응답을 생성
        return ApiResponse.of(SuccessStatus._CREATED, responseDTO);
    }
}
