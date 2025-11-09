package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //외부에서 넣어주도록 변경 = DI
    
    /**
     * 회원 가입
     */
    public Long join(Member member) {

            extracted(member); //중복 회원 검사
            memberRepository.save(member);
            return member.getId();

    }

    private void extracted(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
              throw new IllegalStateException("이미 존재하는 회원입니다.");
          });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){

            return memberRepository.findById(id);

    }
}
