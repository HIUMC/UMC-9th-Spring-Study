package UMC.week4.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.time.LocalDate;

public class MissionRequestDto {

    @Getter
    public static class CreateMissionDto {

        @NotBlank(message = "미션 내용은 비워둘 수 없습니다.")
        private String content;

        @NotNull(message = "미션 보상은 비워둘 수 없습니다.")
        @Min(value = 1, message = "보상은 1 이상이어야 합니다.")
        private Integer point;

        @NotNull(message = "마감 기한은 비워둘 수 없습니다.")
        private LocalDate deadline;
    }
}
