package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.GeneralSuccessCode;
import com.example.umcworkbook.converter.TestConverter;
import com.example.umcworkbook.dto.res.TestResDto;
import com.example.umcworkbook.service.query.TestQueryService;
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
    public ApiResponse<TestResDto.Testing> test() throws Exception {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDto("This is Test!")
        );
    }

    @GetMapping("/exception")
    public ApiResponse<TestResDto.Exception> exception(
            @RequestParam Long flag
    ) {
        testQueryService.checkFlag(flag);

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDto("This is Test!"));
    }
}
