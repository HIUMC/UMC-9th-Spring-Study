package com.example.umc9th.domain.store.entity;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store") // 실제 테이블명과 매핑
@Getter // Lombok: 모든 필드의 Getter 메서드를 자동으로 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok: JPA 스펙상 필요한 기본 생성자 (PROTECTED 권장)
public class Store {
    /**
     * 가게 ID (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    /**
     * 식당 이름 (VARCHAR(50))
     * - length = 50: 스키마에 맞춰 최대 길이를 50으로 지정
     */
    @Column(name = "store_name", nullable = false, length = 50)
    private String storeName;

    /**
     * 사장님 구분번호 (BIGINT)
     */
    @Column(name = "manager_number")
    private Long managerNumber;

    /**
     * 상세 주소 (VARCHAR)
     */
    @Column(name = "detail_address")
    private String detailAddress;


    // --- 연관관계 매핑 ---

    /**
     * (양방향) 이 가게에 달린 리뷰 목록
     * - @OneToMany: 1:N 연관관계. 가게(1)는 여러 리뷰(N)를 가짐.
     * - mappedBy = "store": 'Review' 엔티티에 있는 'store' 필드가 연관관계의 주인임을 명시.
     * - cascade = CascadeType.ALL: 가게가 삭제될 때 이 가게에 달린 리뷰들도 함께 삭제 (영속성 전이)
     */
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    public List<Mission> getMissions() {
        return missionList;
    }
}