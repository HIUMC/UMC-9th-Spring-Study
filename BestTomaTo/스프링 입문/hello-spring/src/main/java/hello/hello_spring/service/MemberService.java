package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public long join(Member member) {
        this.validateDuplicateMember(member);
        this.memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        this.memberRepository.findByName(member.getName()).ifPresent((m) -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberid) {
        return this.memberRepository.findById(memberid);
    }
}