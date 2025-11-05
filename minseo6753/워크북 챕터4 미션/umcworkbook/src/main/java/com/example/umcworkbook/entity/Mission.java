package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import jakarta.persistence.*;

@Entity
@Table(name = "mission")
public class Mission extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "price")
    private Integer price;

    @Column(name = "point")
    private Integer point;

    @Column(name = "days_left")
    private Integer daysLeft;
}
