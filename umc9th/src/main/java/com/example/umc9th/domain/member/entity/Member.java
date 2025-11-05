package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.entity.enums.Gender;
import com.example.umc9th.domain.member.entity.enums.LoginType;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private Date dateOfBirth;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private LoginType loginType;
    //... 기타 사용자 정보 필드들

    private Long point;



    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberFood> memberFoodList = new ArrayList<>();
}