package com.example.umcworkbook.entity.image;

import com.example.umcworkbook.entity.Inquiry;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquiry_image")
public class InquiryImage extends Image {

    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;
}
