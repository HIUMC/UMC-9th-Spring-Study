package com.example.Chapter6.domain.user.service.query;

import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface MemberQueryService {
    MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto);
}
