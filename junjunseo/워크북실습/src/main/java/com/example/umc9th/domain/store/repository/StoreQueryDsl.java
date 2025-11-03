package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StoreQueryDsl {
    Page<Store> searchStores(
            Optional<List<Region>> regions,
            Optional<String> keyword,
            Optional<String> sort,
            Pageable pageable
    );
}
