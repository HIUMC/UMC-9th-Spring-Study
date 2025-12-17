package com.example.umcworkbook.service.query;

import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;
import jakarta.validation.Valid;

public interface MemberQueryService {
    MemberResDto.LoginDto login(MemberReqDto.@Valid LoginDto dto);
}
