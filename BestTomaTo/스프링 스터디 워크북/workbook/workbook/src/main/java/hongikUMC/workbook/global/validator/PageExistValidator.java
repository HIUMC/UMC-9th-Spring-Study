package hongikUMC.workbook.global.validator;

import hongikUMC.workbook.global.annotation.ExistPage;
import jakarta.validation.ConstraintValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<ExistPage, List<Long>> {




}
