package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.enums.Region;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StoreQueryDslImpl implements StoreQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Store> searchStores(
            Optional<List<Region>> regions,
            Optional<String> keyword,
            Optional<String> sort,
            Pageable pageable
    ) {
        QStore store = QStore.store;

        List<Store> stores = queryFactory
                .selectFrom(store)
                .where(
                        regionIn(regions),
                        keywordFilter(keyword)
                )
                .orderBy(sortOrder(sort), store.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = queryFactory
                .select(store.count())
                .from(store)
                .where(
                        regionIn(regions),
                        keywordFilter(keyword)
                )
                .fetchOne();

        return PageableExecutionUtils.getPage(stores, pageable, () -> count);
    }

    /** 지역 필터 */
    private BooleanExpression regionIn(Optional<List<Region>> regions) {
        return regions
                .filter(list -> !list.isEmpty())
                .map(list -> QStore.store.region.in(list))
                .orElse(null);
    }

    /** 키워드 검색 */
    private BooleanExpression keywordFilter(Optional<String> keywordOpt) {
        if (keywordOpt.isEmpty()) return null;
        String keyword = keywordOpt.get().trim().toLowerCase();
        QStore store = QStore.store;

        if (keyword.contains(" ")) {
            String[] parts = keyword.split("\\s+");
            BooleanExpression condition = null;
            for (String part : parts) {
                BooleanExpression expr = store.name.lower().like("%" + part + "%");
                condition = (condition == null) ? expr : condition.or(expr);
            }
            return condition;
        } else {
            return store.name.lower().like("%" + keyword + "%");
        }
    }

    /** 정렬 기준 */
    private OrderSpecifier<?> sortOrder(Optional<String> sortOpt) {
        QStore store = QStore.store;
        return sortOpt.map(sort -> {
            switch (sort) {
                case "name":
                    return store.name.asc();
                case "latest":
                default:
                    return store.createdAt.desc();
            }
        }).orElse(store.createdAt.desc());
    }
}
