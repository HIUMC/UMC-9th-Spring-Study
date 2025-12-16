package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;

public interface MemberQueryService {
    // 로그인 로직
    MemberResponseDTO.LoginDTO login(MemberRequestDTO.LoginDTO request);
}