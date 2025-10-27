package com.example.umcworkbook.entity.image;

import com.example.umcworkbook.entity.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review_image")
public class ReviewImage extends Image {

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
