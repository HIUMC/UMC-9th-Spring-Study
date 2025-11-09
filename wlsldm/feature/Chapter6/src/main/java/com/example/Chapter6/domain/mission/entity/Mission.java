package com.example.Chapter6.domain.mission.entity;

import com.example.Chapter6.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.naming.Name;
import java.util.Date;



@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "missions")
@EntityListeners(AuditingEntityListener.class)
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

    @Column(name = "expired_at", length = 6, nullable = false)
    private Date expiredAt;

    @Column(name = "content",length = 20, nullable = false)
    private String content;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "owner_num", length = 6,nullable = false)
    private String ownerNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
