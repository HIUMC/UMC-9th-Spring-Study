package com.example.umcworkbook;

import com.example.umcworkbook.entity.Category;
import com.example.umcworkbook.entity.Mission;
import com.example.umcworkbook.entity.Restaurant;
import com.example.umcworkbook.entity.Review;
import com.example.umcworkbook.repository.CategoryRepository;
import com.example.umcworkbook.repository.MissionRepository;
import com.example.umcworkbook.repository.RestaurantRepository;
import com.example.umcworkbook.repository.ReviewRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UmcworkbookApplicationTests {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CategoryRepository categoryRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MissionRepository missionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveReview() {
		Review review = Review.builder()
				.content("리뷰내용1")
				.star(4.2f)
				.build();
		reviewRepository.save(review);

	}

	@Test
	void saveCategory(){
		Category category = Category.builder()
				.name("중식")
				.build();
		categoryRepository.save(category);
	}

	@Test
	void saveRestaurant() {
		Restaurant restaurant = Restaurant.builder()
				.name("식당")
				.build();
		restaurantRepository.save(restaurant);
	}

	@Test
	void saveMission() {
		Mission mission=Mission.builder()
				.build();
		missionRepository.save(mission);
	}

}
