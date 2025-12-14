package UMC.week4.service;

import UMC.week4.config.SecurityConfig;
import UMC.week4.converter.MemberConverter;
import UMC.week4.domain.Member;
import UMC.week4.dto.MemberReqDto;
import UMC.week4.dto.MemberResDto;
import UMC.week4.global.jwt.JwtUtil;
import UMC.week4.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResDto.JoinResultDto join(MemberReqDto.JoinDto request) {
        // 이메일 중복 체크 등 검증 로직 추가 가능
        if(memberRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("이미 존재하는 이메일입니다."); // 커스텀 예외로 변경 권장
        }

        Member newMember = MemberConverter.toMember(request, passwordEncoder);
        Member savedMember = memberRepository.save(newMember);

        return MemberConverter.toJoinResultDTO(savedMember);
    }

    @Transactional
    public MemberResDto.LoginResultDTO login(MemberReqDto.LoginDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        // 인증 객체 생성 및 토큰 발급
        CustomUserDetails userDetails = new CustomUserDetails(member);
        String accessToken = jwtUtil.createAccessToken(userDetails);

        return MemberConverter.toLoginResultDTO(member.getId(), accessToken);
    }
}
