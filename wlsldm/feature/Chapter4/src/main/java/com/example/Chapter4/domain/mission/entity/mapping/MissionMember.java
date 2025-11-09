package com.example.Chapter4.domain.mission.entity.mapping;

import com.example.Chapter4.domain.mission.entity.Mission;
import com.example.Chapter4.domain.mission.enums.Complete;
import com.example.Chapter4.domain.user.entity.Member;
import com.example.Chapter4.domain.user.enums.SocialType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "missionMember")
@EntityListeners(AuditingEntityListener.class)
public class MissionMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "complete", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Complete complete = Complete.FAILURE;

    @Column(name = "complete_at", length = 6, nullable = false)
    private Date completeAt;




}
