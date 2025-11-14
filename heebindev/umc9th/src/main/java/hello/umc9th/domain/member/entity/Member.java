package hello.umc9th.domain.member.entity;


import hello.umc9th.domain.member.enums.Gender;
import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Builder //빌더
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE)//기본 생성자 생성
@Getter
@Table(name = "member") //member 테이블.
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {//생성수정삭제는 상속받기.
    //Pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //멤버 이름
    @Column(name="name", nullable = false)
    private String name;

    //성별
    @Column(name="gender", nullable = false)
    @Enumerated(EnumType.STRING)//enum은 이렇게 해야지 문자열로 나옴.
    @Builder.Default //디폴트값 NONE
    private Gender gender= Gender.NONE;

    //주소
    @Column(name="address", nullable = false)
    private String address;

    //포인트
    @Column(name="point",nullable = false)
    @Builder.Default //디폴트값 0
    private int point = 0;

    //전화번호
    @Column(name="phoneNumber",length = 11)//길이 제한
    private String phoneNumber;

    //생성, 수정, 삭제 일자는 상속받음.

}
