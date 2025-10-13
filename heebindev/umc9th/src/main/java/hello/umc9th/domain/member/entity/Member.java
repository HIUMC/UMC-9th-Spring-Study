package hello.umc9th.domain.member.entity;


import hello.umc9th.domain.member.entity.mapping.MemberFood;
import hello.umc9th.domain.member.enums.Gender;
import hello.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {
    @Id //PK는 id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //이름
    @Column(name = "name", length = 5, nullable = false)
    private String name;

    //성별
    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    //생년월일
    @Column(name="birth", nullable = false)
    private LocalDate birth;

    //폰 번호
    @Column(name="phone_number", nullable = true, length = 11)
    private String phoneNumber;
    //int로 하면 010하면 앞의 0이 날라가서 10으로 저장됨.

    //주소
    @Column(name="address", nullable = false)
    private String address;

    //약관동의 여부
    @Column(name="agree", nullable = false)
    @Builder.Default
    private boolean agree = false;
    //디폴트로 false로 해두고는 사용자가 명시적으로 동의(true)를 눌러야 의미가 있을듯

    //연관관계
    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFoods = new ArrayList<>();
}
