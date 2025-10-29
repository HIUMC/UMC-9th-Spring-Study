package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    Member signUp(MemberRequestDTO.SignUpDTO request);

    List<Review> getMyReviews(Long memberId);

    Page<UserMission> getMyMissions(Long memberId, boolean completed, Pageable pageable);
}