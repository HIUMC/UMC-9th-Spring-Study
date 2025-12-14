package UMC.week4.converter;

import UMC.week4.domain.Member;
import UMC.week4.domain.enums.Gender;
import UMC.week4.domain.enums.Role;
import UMC.week4.dto.MemberReqDto;
import UMC.week4.dto.MemberReqDto;
import UMC.week4.dto.MemberResDto;
import UMC.week4.dto.MemberResDto;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

public class MemberConverter {

    public static MemberResDto.JoinResultDto toJoinResultDTO(Member member){
        return MemberResDto.JoinResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResDto.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken){
        return MemberResDto.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static Member toMember(MemberReqDto.JoinDto request, PasswordEncoder passwordEncoder){
        Gender gender = null; // Gender 처리 로직 필요 시 추가

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // 비밀번호 암호화
                .gender(request.getGender())
                .birth(request.getBirthYear() + "-" + request.getBirthMonth() + "-" + request.getBirthDay())
                .address(request.getAddress() + " " + request.getSpecAddress())
                .nickName(request.getNickName())
                .role(Role.ROLE_USER) // 기본 권한 USER
                .build();
    }
}
