package com.example.Chapter6.domain.user.entity;

import com.example.Chapter6.domain.mission.entity.mapping.MissionMember;
import com.example.Chapter6.domain.user.entity.mapping.MemberFood;
import com.example.Chapter6.domain.user.entity.mapping.MemberTerm;
import com.example.Chapter6.domain.user.enums.SocialType;
import com.example.Chapter6.domain.user.enums.Status;
import com.example.Chapter6.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "name", length = 3, nullable = false)
    private String name;

    @Column( name = "email", length = 30, nullable = false)
    private String email;

    @Column (name = "phone_num", length = 11, nullable = false)
    private String phoneNum;

    @Column(name = "social_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "point", nullable = false)
    @Builder.Default
    private Integer point = 0;

    @Column(name = "status", nullable = false)
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
