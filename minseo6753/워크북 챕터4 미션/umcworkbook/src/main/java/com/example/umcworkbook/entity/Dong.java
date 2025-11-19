package com.example.umcworkbook.entity;

import jakarta.persistence.*;

@Entity
public class Dong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10)
    private String name;
}
