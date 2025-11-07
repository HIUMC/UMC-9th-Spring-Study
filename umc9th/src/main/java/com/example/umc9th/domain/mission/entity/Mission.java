package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    //    CREATE TABLE `Mission` (
//            `mission_id`	BIGINT	NOT NULL,
//            `deadline`	DATE	NULL,
//	`conditional`	VARCHAR	NULL,
//	`title`	VARCHAR(100)	NULL,
//	`point`	INT	NULL,
//	`created_at`	DATE	NULL,
//	`store_id`	BIGINT	NOT NULL
//);
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

    @Column(nullable = false)
    private Long storeId;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}