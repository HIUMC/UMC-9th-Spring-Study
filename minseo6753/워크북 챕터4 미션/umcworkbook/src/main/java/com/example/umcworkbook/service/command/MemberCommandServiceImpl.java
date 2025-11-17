package com.example.umcworkbook.service.command;

import com.example.umcworkbook.converter.MemberConverter;
import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;
import com.example.umcworkbook.entity.Category;
import com.example.umcworkbook.entity.Member;
import com.example.umcworkbook.entity.Preference;
import com.example.umcworkbook.repository.CategoryRepository;
import com.example.umcworkbook.repository.MemberRepository;
import com.example.umcworkbook.repository.PreferenceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final PreferenceRepository preferenceRepository;

    @Override
    @Transactional
    public MemberResDto.JoinDto signup(
            MemberReqDto.JoinDto dto
    ) {
        Member member = MemberConverter.toMember(dto);
        memberRepository.save(member);

        if (dto.categories().size() > 1) {

            //categories가 이미 @Valid로 검증됨
            List<Category> categories = categoryRepository.findAllById(dto.categories());

            List<Preference> preferences = categories.stream()
                    .map(category -> Preference.builder()
                            .member(member)
                            .category(category)
                            .build()
                    )
                    .collect(Collectors.toList());

            preferenceRepository.saveAll(preferences);
        }

        return MemberConverter.toJoinDto(member);
    }
}
