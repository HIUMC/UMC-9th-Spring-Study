package hongikUMC.workbook.domain.test.service.query;

import hongikUMC.workbook.domain.test.exception.TestException;
import hongikUMC.workbook.domain.test.exception.code.TestErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService{

    @Override
    public void checkFlag(Long flag) {
        if (flag == 1){
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}
