package com.example.Chapter4.domain.user.repository;

import com.example.Chapter4.domain.user.entity.Member;
import com.example.Chapter4.domain.user.projection.MypageInfo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;



public interface MypageRepository extends JpaRepository<Member, Long> {
    Optional<MypageInfo> findMypageById(Long id) ;
}