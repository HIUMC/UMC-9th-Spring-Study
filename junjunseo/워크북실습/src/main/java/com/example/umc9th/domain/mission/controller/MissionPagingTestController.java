package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/missions")
public class MissionPagingTestController {

    private final MissionRepository missionRepository;

    /**
     * Page 기반 페이징 테스트
     * count 쿼리가 반드시 실행됨
     */
    @GetMapping("/page")
    public Page<Mission> getMissionPage(
            @RequestParam(defaultValue = "1") int page
    ) {
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return missionRepository.findAllByStore_Id(1L, pageable);
    }

    /**
     * Slice 기반 페이징 테스트
     * count 쿼리가 절대 실행되지 않음
     */
    @GetMapping("/slice")
    public Slice<Mission> getMissionSlice(
            @RequestParam(defaultValue = "1") int page
    ) {
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return missionRepository.findSliceByStore_Id(1L, pageable);
    }
}
