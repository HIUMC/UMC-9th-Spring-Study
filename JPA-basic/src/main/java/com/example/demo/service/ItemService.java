package com.example.demo.service;

import com.example.demo.domain.Item.Item;
import com.example.demo.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service // 1. 이 클래스는 비즈니스 로직을 처리하는 서비스 계층입니다.
@Transactional(readOnly = true) // 2. 클래스 전체에 트랜잭션을 적용합니다 (읽기 전용).
@RequiredArgsConstructor // 3. final 필드에 대한 생성자를 자동으로 만들어줍니다.
public class ItemService {

    /**
     * ItemRepository를 의존성으로 주입받습니다.
     * ItemService는 데이터베이스에 직접 접근하지 않고, ItemRepository에게 데이터 관련 작업을 위임합니다.
     */
    private final ItemRepository itemRepository; // 4. ItemRepository를 주입받습니다.

    @Transactional // 5. 쓰기 작업에는 별도의 트랜잭션을 적용합니다.
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 6. 상품 전체 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 7. 상품 단건 조회
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}