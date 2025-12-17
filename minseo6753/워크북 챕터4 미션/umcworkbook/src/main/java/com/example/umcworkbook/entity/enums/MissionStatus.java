package com.example.umcworkbook.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MissionStatus {
    ONGOING("진행중"),
    COMPLETED("성공"),
    FAILED("실패"),
    ;

    private final String message;
}
