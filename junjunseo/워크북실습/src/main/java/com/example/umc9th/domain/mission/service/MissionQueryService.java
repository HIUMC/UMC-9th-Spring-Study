package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public Page<MissionResDto.StoreMissionDto> getStoreMissions(Long storeId, Integer page) {

        int pageIndex = page - 1; // 프론트는 1부터, JPA는 0부터

        PageRequest pageable = PageRequest.of(
                pageIndex,
                10, // 한 페이지 10개
                Sort.by(Sort.Direction.DESC, "createdAt") // 최신순 정렬 (BaseEntity에 createdAt 있다고 가정)
        );

        Page<Mission> missionPage = missionRepository.findAllByStoreId(storeId, pageable);

        return MissionConverter.toStoreMissionPage(missionPage);
    }

    public Page<MissionResDto.MyOngoingMissionDto> getMyOngoingMissions(Integer page) {

        int pageIndex = page - 1;

        PageRequest pageable = PageRequest.of(
                pageIndex,
                10,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Long memberId = 1L;

        Page<MemberMission> missionPage =
                memberMissionRepository.findAllByMemberIdAndIsCompleteFalse(memberId, pageable);

        return MissionConverter.toMyOngoingMissionPage(missionPage);
    }
}