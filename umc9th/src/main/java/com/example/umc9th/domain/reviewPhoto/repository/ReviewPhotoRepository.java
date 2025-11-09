package com.example.umc9th.domain.reviewPhoto.repository;

import com.example.umc9th.domain.reviewPhoto.entity.ReviewPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, Long> {
}
