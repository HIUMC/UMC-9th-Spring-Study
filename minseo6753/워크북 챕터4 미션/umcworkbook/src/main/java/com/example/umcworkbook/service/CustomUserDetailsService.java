package com.example.umcworkbook.service;

import com.example.umcworkbook.CustomUserDetails;
import com.example.umcworkbook.apiPayload.code.error.MemberErrorCode;
import com.example.umcworkbook.apiPayload.exception.MemberException;
import com.example.umcworkbook.entity.Member;
import com.example.umcworkbook.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));
        return new CustomUserDetails(member);
    }
}
