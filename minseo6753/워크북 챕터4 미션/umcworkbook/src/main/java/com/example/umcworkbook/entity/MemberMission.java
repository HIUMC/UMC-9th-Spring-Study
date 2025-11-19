package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import com.example.umcworkbook.entity.enums.MissionStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "member_mission")
public class MemberMission extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(name = "classify_num")
    private Long classifyNum;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;
}
