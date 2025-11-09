package UMC.week4.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import java.util.List;

@Getter
@Builder
public class ReviewPageDto {
    private List<ReviewResponseDto> reviewList;
    private Integer totalPages;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer page; // 현재 페이지 번호 (0-based)
    private Integer size; // 페이지 크기

    // Page<ReviewResponseDto> 객체를 받아서 ReviewPageDto로 변환
    public static ReviewPageDto from(Page<ReviewResponseDto> page) {
        return ReviewPageDto.builder()
                .reviewList(page.getContent())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .page(page.getNumber())
                .size(page.getSize())
                .build();
    }
}
