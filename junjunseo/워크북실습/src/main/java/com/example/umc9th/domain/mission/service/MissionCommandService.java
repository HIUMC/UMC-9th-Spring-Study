package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;

    public MissionResDto createMission(MissionReqDto req) {

        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Mission mission = Mission.builder()
                .store(store)
                .deadline(req.getDeadline())
                .conditional(req.getConditional())
                .point(req.getPoint())
                .build();

        Mission saved = missionRepository.save(mission);

        return MissionConverter.toMissionResDto(saved);
    }

    @Transactional
    public MissionResDto.CompletedMissionDto completeMission(Long missionId) {

        Long memberId = 1L; // 로그인 붙기 전 고정

        MemberMission mm = memberMissionRepository
                .findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        if (mm.isComplete()) {
            throw new MissionException(MissionErrorCode.ALREADY_COMPLETED);
        }

        // 완료 처리
        mm.setComplete(true);

        return MissionConverter.toCompletedMissionDto(mm);
    }
}
