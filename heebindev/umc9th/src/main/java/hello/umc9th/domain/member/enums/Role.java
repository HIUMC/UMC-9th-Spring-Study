package hello.umc9th.domain.member.enums;

//사용자 역할을 정의하는 enum 타입

public enum Role {
    //SecurityConfig의 hasRole 메서드를 사용하기 위해서는 DB에 ROLE_접두사 필수
    ROLE_ADMIN, ROLE_USER
}
