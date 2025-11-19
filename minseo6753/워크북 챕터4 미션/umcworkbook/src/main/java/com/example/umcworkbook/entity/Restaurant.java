package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import jakarta.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "star")
    private Float star;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "dong_id")
    private Dong dong;
}
