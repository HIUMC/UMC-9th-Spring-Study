package hello2.core2.member;

import java.util.Map;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);


}
