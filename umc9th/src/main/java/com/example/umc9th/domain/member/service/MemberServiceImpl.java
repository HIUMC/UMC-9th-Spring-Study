package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.Food.entity.Food;
import com.example.umc9th.domain.Food.repository.FoodRepository;
import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member signUp(MemberRequestDTO request) {

        Member newMember = MemberConverter.toMember(request);

        // 컨트롤러의 @Valid가 preferFood의 모든 ID가 DB에 존재함을 보장합니다.
        // 따라서 orElseThrow 없이 .get()으로 바로 엔티티를 가져올 수 있습니다.
        List<Food> foodList = request.getPreferFood().stream()
                .map(foodId -> foodRepository.findById(foodId).get())
                .collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFood.createMemberFoodList(foodList);

        memberFoodList.forEach(memberFood -> {
            memberFood.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }
}
