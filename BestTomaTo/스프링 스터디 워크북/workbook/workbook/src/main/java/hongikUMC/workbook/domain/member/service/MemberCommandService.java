package hongikUMC.workbook.domain.member.service;

import hongikUMC.workbook.domain.member.converter.MemberConverter;
import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.entity.Food;
import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.entity.mapped.MemberFood;
import hongikUMC.workbook.domain.member.exception.FoodException;
import hongikUMC.workbook.domain.member.exception.code.FoodErrorCode;
import hongikUMC.workbook.domain.member.repository.FoodRepository;
import hongikUMC.workbook.domain.member.repository.MemberFoodRepository;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.global.auth.enums.Role;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final MemberFoodRepository memberFoodRepository;

    // 보안용
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public MemberResDTO.JoinDTO signUp(
            MemberReqDTO.JoinDTO joinDTO
    ){
        // 솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(joinDTO.password());

        // 회원가입 사용자 데이터 저장
        Member member = MemberConverter.toMember(joinDTO, salt, Role.ROLE_USER);
        memberRepository.save(member);

        // 사용자 선호 음식 확인
        if(joinDTO.preferCategory().size() > 1){
            List<MemberFood> memberFoodList = new ArrayList<>();

            // 사용자 선호 음식 찾기
            for(Long x : joinDTO.preferCategory()){
                Food food = foodRepository.findById(x)
                        .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));

                // MemberFood 엔티티 생성
                MemberFood memberFood = MemberFood.builder()
                        .member(member)
                        .food(food)
                        .build();

                // 한 사용자의 리스트 안에 보관
                memberFoodList.add(memberFood);
            }

            // 해당 리스트 전부 DB에 저장
            memberFoodRepository.saveAll(memberFoodList);
        }

        // 컨버터를 이용해 ResDTO로 반환
        return MemberConverter.toJoinDTO(member);
    }
}
