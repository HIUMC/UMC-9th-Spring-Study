package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.store.entity.Store;
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
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    @Column
    private Date deadline;

    // 미션 조건
    @Column(nullable = false)
    private String conditional;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UserMission> userMissionList = new ArrayList<>();

    // --- 편의 메서드 ---
    public void setStore(Store store) {
        if (this.store != null) {
            this.store.getMissions().remove(this);
        }
        this.store = store;
        store.getMissions().add(this);
    }
}