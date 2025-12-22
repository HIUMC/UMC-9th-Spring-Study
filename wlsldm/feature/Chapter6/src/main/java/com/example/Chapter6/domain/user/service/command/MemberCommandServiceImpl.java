package com.example.Chapter6.domain.user.service.command;

import com.example.Chapter6.domain.user.converter.MemberConverter;
import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import com.example.Chapter6.domain.user.entity.Food;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.domain.user.entity.mapping.MemberFood;
import com.example.Chapter6.domain.user.exception.FoodException;
import com.example.Chapter6.domain.user.exception.code.FoodErrorCode;
import com.example.Chapter6.domain.user.repository.MemberFoodRepository;
import com.example.Chapter6.domain.user.repository.MemberRepository;
import com.example.Chapter6.global.auth.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final MemberFoodRepository memberFoodRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        String salt = passwordEncoder.encode(dto.password());


        Member member = MemberConverter.toMember(dto, salt, Role.ROLE_USER);
        memberRepository.save(member);

        if (dto.preferCategory().size()>1){
            List<MemberFood> memberFoodList = new ArrayList<>();

            for (Long id: dto.preferCategory()){

                Food food = foodRepository.findById(id).orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));

                MemberFood memberFood = MemberFood.builder()
                        .member(member)
                        .food(food)
                        .build();

                memberFoodList.add(memberFood);
            }

            memberFoodRepository.saveAll(memberFoodList);
        }
        return MemberConverter.toJoinDTO(member);
    }
}
