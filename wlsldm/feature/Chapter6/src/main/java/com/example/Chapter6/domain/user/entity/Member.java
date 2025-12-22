package com.example.Chapter6.domain.user.entity;

import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import com.example.Chapter6.domain.user.entity.mapping.MemberFood;
import com.example.Chapter6.domain.user.entity.mapping.MemberTerm;
import com.example.Chapter6.domain.user.enums.Gender;
import com.example.Chapter6.domain.user.enums.SocialType;
import com.example.Chapter6.domain.user.enums.Status;
import com.example.Chapter6.global.auth.enums.Role;
import com.example.Chapter6.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@Entity
//파라미터가 없는 디폴트 생성자 생성
//같은 패키지 클래스와 상속받은 클래스에서 생성자에 접근 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//클래스의 모든 필드 값을 파라미터로 받는 생성자 생성
//해당 클래스 내부에서만 생성자에 접근 가능
@AllArgsConstructor(access = AccessLevel.PRIVATE)

//테이블 이름
@Table(name = "members")

@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column( name = "birth", length = 30, nullable = false)
    private LocalDate birth;

    @Column( name = "email", length = 30, nullable = false)
    private String email;

    @Column ( name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column( name = "gender", length = 30, nullable = false)
    private Gender gender;

    @Column (name = "phone_num", length = 20, nullable = false)
    private String phoneNum;

    @Column(name = "social_type")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private SocialType socialType = SocialType.GOOGLE;

    @Column(name = "point")
    @Builder.Default
    private Integer point = 0;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberFood> memberFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberTerm> memberTermList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MissionMember>  missionMemberList = new ArrayList<>();

}
