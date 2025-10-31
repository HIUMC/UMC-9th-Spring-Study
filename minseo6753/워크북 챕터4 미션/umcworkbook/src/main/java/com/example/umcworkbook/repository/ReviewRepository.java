package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review save(Review review);
}
