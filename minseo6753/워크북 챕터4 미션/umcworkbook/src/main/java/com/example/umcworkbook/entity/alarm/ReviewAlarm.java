package com.example.umcworkbook.entity.alarm;

import com.example.umcworkbook.entity.MemberMission;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review_alarm")
public class ReviewAlarm extends Alarm{

    @OneToOne
    @JoinColumn(name = "member_mission_id")
    private MemberMission memberMission;

}
