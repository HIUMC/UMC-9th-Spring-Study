package com.example.umcworkbook.service.query;

import com.example.umcworkbook.apiPayload.code.TestErrorCode;
import com.example.umcworkbook.apiPayload.exception.TestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Long flag) {
        if (flag == 1) {
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}
