package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import jakarta.persistence.*;

@Entity
@Table(name = "preference")
public class Preference extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
