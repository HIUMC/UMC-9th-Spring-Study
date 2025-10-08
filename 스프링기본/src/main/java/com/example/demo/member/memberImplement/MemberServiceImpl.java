package com.example.demo.member.memberImplement;


import com.example.demo.member.Member;
import com.example.demo.member.memberInterface.MemberRepository;
import com.example.demo.member.memberInterface.MemberService;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
