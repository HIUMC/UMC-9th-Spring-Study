package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import com.example.umcworkbook.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "address",length = 45)
    private String address;

    @Column(name = "nickname",length = 20)
    private String nickname;

    @Column(name = "email",length = 20)
    private String email;

    @Column(name = "phone_num",length = 15)
    private String phoneNum;

    @Column(name = "point")
    private Integer point;

    @Column(name = "mission_cnt")
    private Integer missionCount;

    @Column(name = "inactive_date")
    private LocalDateTime inactiveDate;

    @ManyToOne
    @JoinColumn(name = "dong_id")
    private Dong dong;

}
