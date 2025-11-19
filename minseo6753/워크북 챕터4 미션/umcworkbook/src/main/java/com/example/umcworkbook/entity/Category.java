package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;
}
