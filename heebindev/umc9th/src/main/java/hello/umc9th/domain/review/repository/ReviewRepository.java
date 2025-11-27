package hello.umc9th.domain.review.repository;

import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl{

//    //지역만 조회
//    @Query(//sql로 조회하기
//            value = "select r1.* " +
//                    "from review r1 " +
//                    "left join store s1 on r1.storeId = s1.id " +
//                    "left join location l1 on s1.locationId=l1.id " +
//                    "where l1.name like CONCAT('%', :name, '%')", nativeQuery=true
//    )
//    List<Review> searchReviewByLocation(@Param("name") String name);
//    //너무 복잡하다.. 동적 쿼리 필요

    //가게별 리뷰 페이징!
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    //특정 회원이 작성한 리뷰 페이징 조회
    Page<Review> findAllByMemberId(Long memberId, PageRequest pageRequest);
}
