package UMC.week4.dto;

import UMC.week4.domain.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberReqDto {
    @Getter
    @Setter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Gender gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @NotBlank
        String address;
        @NotBlank
        String specAddress;
        @NotBlank
        String nickName;
    }

    @Getter
    @Builder
    public static class LoginDTO{
            String email;
            String password;
    }
}
