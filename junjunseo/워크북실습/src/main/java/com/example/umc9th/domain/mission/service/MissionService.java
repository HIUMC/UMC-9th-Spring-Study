package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionCreateRequestDto;
import com.example.umc9th.domain.mission.dto.MissionResponseDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public MissionResponseDto createMission(MissionCreateRequestDto req) {

        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Mission mission = Mission.builder()
                .store(store)
                .deadline(req.getDeadline())
                .conditional(req.getConditional())
                .point(req.getPoint())
                .build();

        Mission saved = missionRepository.save(mission);

        return MissionResponseDto.from(saved);
    }
}
