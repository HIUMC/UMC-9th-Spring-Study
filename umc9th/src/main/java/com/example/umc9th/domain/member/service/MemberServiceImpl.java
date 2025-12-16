package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.Food.entity.Food;
import com.example.umc9th.domain.Food.repository.FoodRepository;
import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO; // 추가
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.enums.Role;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.config.jwt.JwtUtil;
import com.example.umc9th.global.config.security.CustomUserDetails;
import com.example.umc9th.global.exception.handler.MemberHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    // 파라미터를 MemberRequestDTO -> MemberRequestDTO.JoinDTO로 수정
    public Member signUp(MemberRequestDTO.JoinDTO request) {

        // DTO의 필드 접근을 레코드 방식(.password())으로 변경
        String encodedPassword = passwordEncoder.encode(request.password());

        Member newMember = MemberConverter.toMember(request, encodedPassword, Role.ROLE_USER);

        // DTO의 필드 접근을 레코드 방식(.preferFood())으로 변경
        List<Food> foodList = request.preferFood().stream()
                .map(foodId -> foodRepository.findById(foodId).get())
                .collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFood.createMemberFoodList(foodList);

        memberFoodList.forEach(memberFood -> {
            memberFood.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }

    @Override
    public MemberResponseDTO.LoginDTO login(MemberRequestDTO.LoginDTO request) {
        // 1. 이메일로 사용자 조회
        Member member = memberRepository.findByEmail(request.email())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        // 2. 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(request.password(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.MEMBER_PASSWORD_NOT_MATCH);
        }

        // 3. CustomUserDetails 객체 생성
        CustomUserDetails userDetails = new CustomUserDetails(member);

        // 4. JWT 토큰 생성 (UserDetails 사용)
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // 5. LoginDTO 반환
        return MemberResponseDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}
