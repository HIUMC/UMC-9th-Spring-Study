package hongikUMC.workbook.domain.review.dto.res;

import hongikUMC.workbook.domain.review.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {

    @Builder
    public static record ReviewDTO(
            String title,
            String body,
            Rating rate) {}

    @Builder
    public static record ReviewListDTO (
            List<ReviewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}
}
