package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public Member signUp(MemberRequestDTO.SignUpDTO request) {
        Member newMember = MemberConverter.toMember(request);
        return memberRepository.save(newMember);
    }

    @Override
    public List<Review> getMyReviews(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        return reviewRepository.findByMember(member);
    }

    @Override
    public Page<UserMission> getMyMissions(Long memberId, boolean completed, Pageable pageable) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        return userMissionRepository.findByMemberAndCompleted(member, completed, pageable);
    }
}
