package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Restaurant;
import com.example.umcworkbook.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
