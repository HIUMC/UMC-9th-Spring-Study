package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.service.MemberService;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public MemberResponseDTO.SignUpResultDTO signUp(@RequestBody MemberRequestDTO.SignUpDTO request) {
        Member member = memberService.signUp(request);
        return MemberConverter.toSignUpResultDTO(member);
    }

    @GetMapping("/{memberId}/reviews")
    public List<Review> getMyReviews(@PathVariable Long memberId) {
        return memberService.getMyReviews(memberId);
    }

    @GetMapping("/{memberId}/missions")
    public Page<UserMission> getMyMissions(@PathVariable Long memberId, @RequestParam boolean completed, Pageable pageable) {
        return memberService.getMyMissions(memberId, completed, pageable);
    }
}