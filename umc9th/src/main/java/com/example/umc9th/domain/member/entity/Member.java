package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.LoginType;
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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)", name="gender")
    private Gender gender;

    @Column
    private Date dateOfBirth;

    @Column
    private String address;

    @Column
    private String detailAddress;

    @Column
    private String socialUid;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private LoginType loginType;

    @Column
    private Long point;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberFood> memberFoodList = new ArrayList<>();
}