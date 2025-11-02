package com.example.umc9th.domain.store.service;

import com.example.umc9th.domain.store.dto.StoreResponseDto;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.Region;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<StoreResponseDto> searchStores(
            List<Region> regions,
            String keyword,
            String sort,
            int page,
            int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Store> result = storeRepository.searchStores(
                Optional.ofNullable(regions),
                Optional.ofNullable(keyword),
                Optional.ofNullable(sort),
                pageRequest
        );

        return result.map(StoreResponseDto::from);
    }
}
