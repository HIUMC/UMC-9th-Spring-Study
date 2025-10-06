package umc9th.domain.member.entity;


import umc9th.domain.member.enums.Gender;
import umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")

public class Member extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Column 은 속성
    @Column(name = "name", length = 3, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    //Enumerated 는 Enum 사용할 때 쓰기
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", length = 8, nullable = false)
    private LocalDate birth;

    @Column(name = "address", length = 20, nullable = false)
    private String address;

    @Column(name ="point", nullable = false)
    private Integer point;

    @Column(name = "phone" , length = 11, nullable = false)
    private String phone;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

}
