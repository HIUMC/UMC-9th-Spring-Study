package com.example.Chapter6.domain.test.service.query;

import com.example.Chapter6.domain.test.exception.TestErrorCode;
import com.example.Chapter6.domain.test.exception.TestException;
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
