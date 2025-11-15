package com.example.umcworkbook.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReviewDto {

    private Long id;
    private String content;
    private Float star;
}
