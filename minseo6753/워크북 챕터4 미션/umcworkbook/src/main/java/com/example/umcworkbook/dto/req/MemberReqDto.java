package com.example.umcworkbook.dto.req;

import com.example.umcworkbook.annotation.ExistCategories;
import com.example.umcworkbook.entity.enums.Gender;
import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {

    public record JoinDto(
            String name,
            Gender gender,
            LocalDate birth,
            String address,
            @ExistCategories
            List<Long> categories
    ){}
}
