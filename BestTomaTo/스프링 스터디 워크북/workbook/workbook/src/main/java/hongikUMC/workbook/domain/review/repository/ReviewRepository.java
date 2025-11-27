package hongikUMC.workbook.domain.review.repository;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl{
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
