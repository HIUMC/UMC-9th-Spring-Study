package com.example.umcworkbook.entity;

import com.example.umcworkbook.entity.base.BaseTime;
import com.example.umcworkbook.entity.enums.InquiryStatus;
import com.example.umcworkbook.entity.enums.InquiryType;
import jakarta.persistence.*;

@Entity
@Table(name = "inquiry")
public class Inquiry extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private InquiryType inquiryType;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private InquiryStatus inquiryStatus;
}
