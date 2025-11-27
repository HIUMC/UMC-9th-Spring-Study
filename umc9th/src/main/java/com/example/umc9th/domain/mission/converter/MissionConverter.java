package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getMissionId())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .conditional(mission.getConditional())
                .title(mission.getTitle())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(missionPreviewDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreviewDTOList.size())
                .build();
    }

    public static MissionResponseDTO.ChallengeMissionDTO toChallengeMissionDTO(UserMission userMission) {
        return MissionResponseDTO.ChallengeMissionDTO.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getMissionId())
                .build();
    }

    public static UserMission toUserMission(Mission mission, Member member) {
        return UserMission.builder()
                .mission(mission)
                .member(member)
                .build();
    }

    /**
     * UserMission 엔티티를 ChallengingMissionDTO로 변환하는 메서드
     *
     * @param userMission 변환할 UserMission 엔티티
     * @return ChallengingMissionDTO
     */
    public static MissionResponseDTO.ChallengingMissionDTO toChallengingMissionDTO(UserMission userMission) {
        // UserMission에서 Mission 엔티티를 가져옵니다.
        Mission mission = userMission.getMission();

        return MissionResponseDTO.ChallengingMissionDTO.builder()
                .missionId(mission.getMissionId())
                .reward(mission.getPoint()) // 엔티티의 point 필드를 DTO의 reward 필드로 매핑
                .deadline(mission.getDeadline())
                .missionSpec(mission.getConditional()) // 엔티티의 conditional 필드를 DTO의 missionSpec 필드로 매핑
                .storeName(mission.getStore().getStoreName()) // 연관된 Store 엔티티에서 가게 이름을 가져옴
                .build();
    }

    /**
     * Page<UserMission>을 ChallengingMissionListDTO로 변환하는 메서드
     *
     * @param userMissionPage 페이징된 UserMission 정보
     * @return ChallengingMissionListDTO
     */
    public static MissionResponseDTO.ChallengingMissionListDTO toChallengingMissionListDTO(Page<UserMission> userMissionPage) {
        // 1. Page<UserMission>에서 List<UserMission>을 추출합니다.
        // 2. Stream을 사용하여 List<UserMission>을 List<ChallengingMissionDTO>로 변환합니다.
        List<MissionResponseDTO.ChallengingMissionDTO> missionDTOList = userMissionPage.getContent().stream()
                .map(MissionConverter::toChallengingMissionDTO) // 각 UserMission을 DTO로 변환
                .collect(Collectors.toList()); // 다시 List로 수집

        return MissionResponseDTO.ChallengingMissionListDTO.builder()
                .missionList(missionDTOList)
                .listSize(missionDTOList.size()) // 현재 페이지의 요소 개수
                .totalPage(userMissionPage.getTotalPages()) // 전체 페이지 수
                .totalElements(userMissionPage.getTotalElements()) // 전체 요소 수
                .isFirst(userMissionPage.isFirst()) // 첫 페이지 여부
                .isLast(userMissionPage.isLast()) // 마지막 페이지 여부
                .build();
    }



}