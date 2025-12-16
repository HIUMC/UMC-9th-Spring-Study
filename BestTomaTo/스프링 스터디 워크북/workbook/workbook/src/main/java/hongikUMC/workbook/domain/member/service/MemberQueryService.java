package hongikUMC.workbook.domain.member.service;

import hongikUMC.workbook.domain.member.converter.MemberConverter;
import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.exception.MemberException;
import hongikUMC.workbook.domain.member.exception.code.MemberErrorCode;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.global.auth.entity.CustomUserDetails;
import hongikUMC.workbook.global.auth.entity.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public MemberResDTO.LoginDTO login(
            MemberReqDTO.LoginDTO dto
    ){
        // Member 조회
        Member member = memberRepository.findByEmail(dto.email())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 비밀번호 검증
        if(!encoder.matches(dto.password(), member.getPassword())){
            throw new MemberException(MemberErrorCode.INVALID);
        }

        // JWT 토큰 발급용 UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(member);

        // 엑세스 토큰 발급
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // DTO 조립
        return MemberConverter.toLoginDTO(member, accessToken);
    }
}