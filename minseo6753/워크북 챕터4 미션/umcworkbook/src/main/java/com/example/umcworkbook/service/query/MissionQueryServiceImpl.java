package com.example.umcworkbook.service.query;

import com.example.umcworkbook.apiPayload.code.error.RestaurantErrorCode;
import com.example.umcworkbook.apiPayload.exception.RestaurantException;
import com.example.umcworkbook.dto.res.MissionResDto;
import com.example.umcworkbook.entity.Mission;
import com.example.umcworkbook.entity.Restaurant;
import com.example.umcworkbook.repository.MissionRepository;
import com.example.umcworkbook.repository.RestaurantRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository, RestaurantRepository restaurantRepository) {
        this.missionRepository = missionRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MissionResDto.PreviewListDto findRestaurantMissions(
            Long restaurantId,
            Integer page
    ) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, pageRequest);

        List<MissionResDto.PreviewDto> previewDtos = missionPage.map(
                        mission -> MissionResDto.PreviewDto.builder()
                                .restaurantName(restaurant.getName())
                                .category(restaurant.getCategory().getName())
                                .price(mission.getPrice())
                                .point(mission.getPoint())
                                .days_left(mission.getDaysLeft())
                                .build())
                .toList();

        return MissionResDto.PreviewListDto.builder()
                .missionList(previewDtos)
                .listSize(missionPage.getSize())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
