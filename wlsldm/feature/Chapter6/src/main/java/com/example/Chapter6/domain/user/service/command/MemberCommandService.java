package com.example.Chapter6.domain.user.service.command;

import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;

public interface MemberCommandService {
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}
