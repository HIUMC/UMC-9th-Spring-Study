package hello.umc9th.domain.member.service.command;

import hello.umc9th.domain.member.converter.MemberConverter;
import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;
import hello.umc9th.domain.member.entity.Food;
import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.entity.MemberFood;
import hello.umc9th.domain.member.exception.FoodException;
import hello.umc9th.domain.member.exception.code.FoodErrorCode;
import hello.umc9th.domain.member.repository.FoodRepository;
import hello.umc9th.domain.member.repository.MemberFoodRepository;
import hello.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;
    private final FoodRepository foodRepository;

    //회원 가입
    @Override
    public MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto) {
        //사용자 생성
        Member member = MemberConverter.toMember(dto);

        //DB적용
        memberRepository.save(member);

        //선호 음식 존재 여부
        if (dto.preferCategory().size() > 1) {
            List<MemberFood> memberFoodList = new ArrayList<>();
            //memberFoodList 배열 생성

            //선호 음식 ID별 조회
            for (Long id : dto.preferCategory()) {


                Food food = foodRepository.findById(id)
                        .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));

                //MemberFood 엔티티 생성 (컨버터 사용해야함 )
                MemberFood memberFood = MemberFood.builder()
                        .member(member)
                        .food(food)
                        .build();

                //MemberFood에 추가
                memberFoodList.add(memberFood);
            }

            //선호 음식 추가 DB 적용
            memberFoodRepository.saveAll(memberFoodList);
        }

        return MemberConverter.toJoinDTO(member);
    }
}
