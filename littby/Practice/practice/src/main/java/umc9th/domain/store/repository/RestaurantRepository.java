package umc9th.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc9th.domain.store.entity.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
