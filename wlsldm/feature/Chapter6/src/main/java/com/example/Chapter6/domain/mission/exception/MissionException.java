package com.example.Chapter6.domain.mission.exception;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.Chapter6.global.apiPayload.execption.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
