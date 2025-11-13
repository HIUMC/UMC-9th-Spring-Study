package umc9th.domain.test.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc9th.domain.test.exception.code.TestErrorCode;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Long flag){
        if (flag == 1){
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}
