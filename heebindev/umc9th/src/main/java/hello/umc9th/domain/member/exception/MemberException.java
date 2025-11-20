package hello.umc9th.domain.member.exception;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import hello.umc9th.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    //생성자
    public MemberException(BaseErrorCode code){
        super(code);
    }
}
