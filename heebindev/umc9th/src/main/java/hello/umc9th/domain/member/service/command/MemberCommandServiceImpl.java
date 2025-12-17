package hello.umc9th.domain.member.service.command;

import hello.umc9th.domain.member.converter.MemberConverter;
import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;
import hello.umc9th.domain.member.entity.Food;
import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.entity.MemberFood;
import hello.umc9th.domain.member.enums.Role;
import hello.umc9th.domain.member.exception.FoodException;
import hello.umc9th.domain.member.exception.code.FoodErrorCode;
import hello.umc9th.domain.member.repository.FoodRepository;
import hello.umc9th.domain.member.repository.MemberFoodRepository;
import hello.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;
    private final FoodRepository foodRepository;

    //PasswordEncoder로 암호화를 위한 코드
    private final PasswordEncoder passwordEncoder;

    //회원 가입
    @Override
    public MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto) {
        //솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(dto.password());

        //사용자 생성
        //인자가 3개로 늘었다.
        Member member = MemberConverter.toMember(dto,salt, Role.ROLE_USER);

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
