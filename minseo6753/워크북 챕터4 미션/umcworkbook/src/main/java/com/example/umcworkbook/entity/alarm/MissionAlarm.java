package com.example.umcworkbook.entity.alarm;

import com.example.umcworkbook.entity.Mission;
import jakarta.persistence.*;

@Entity
@Table(name = "mission_alarm")
public class MissionAlarm extends Alarm {

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
