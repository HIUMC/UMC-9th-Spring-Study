package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

    Review save(Review review);
}
