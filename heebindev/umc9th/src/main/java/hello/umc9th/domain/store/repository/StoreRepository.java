package hello.umc9th.domain.store.repository;

import hello.umc9th.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    //페이징를 위해서
    Optional<Store> findByName(String name); //가게명 검색
}
