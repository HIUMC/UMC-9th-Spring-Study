package com.example.umcworkbook.service.command;

import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;

public interface MemberCommandService {

    MemberResDto.JoinDto signup(
            MemberReqDto.JoinDto dto
    );
}
