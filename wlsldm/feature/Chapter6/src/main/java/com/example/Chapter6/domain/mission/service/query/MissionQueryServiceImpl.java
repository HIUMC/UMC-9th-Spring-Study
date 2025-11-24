package com.example.Chapter6.domain.mission.service.query;

import com.example.Chapter6.domain.mission.converter.MissionConverter;
import com.example.Chapter6.domain.mission.dto.response.MissionResDTO;
import com.example.Chapter6.domain.mission.entity.Mission;
import com.example.Chapter6.domain.mission.enums.Complete;
import com.example.Chapter6.domain.mission.repository.MissionRepository;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.store.exception.StoreException;
import com.example.Chapter6.domain.store.exception.code.StoreErrorCode;
import com.example.Chapter6.domain.store.repository.StoreRepository;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.domain.user.exception.MemberException;
import com.example.Chapter6.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public MissionResDTO.MissionPreViewListDTO findMission(
            String storeName,
            Integer page
    ){
        // - 가게를 가져온다 (가게 존재 여부 검증)
        Store store = storeRepository.findByName(storeName)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return MissionConverter.toMissionPreviewListDTO(result);
    }

    @Override
    public MissionResDTO.MissionPreViewListDTO findMyMission(Long userId, Integer page) {
        // 유저 검색
        Member member = memberRepository.findById(userId)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new MemberException(StoreErrorCode.NOT_FOUND));

        //- 유저가 진행 중인 미션을 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Mission> result = missionRepository.findMission(userId, Complete.FAILURE, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return MissionConverter.toMissionPreviewListDTO(result);
    }

}
