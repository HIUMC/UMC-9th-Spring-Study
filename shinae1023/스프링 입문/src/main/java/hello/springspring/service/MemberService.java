package hello.springspring.service;

import hello.springspring.domain.Member;
import hello.springspring.repository.MemberRepositiry;
import hello.springspring.repository.MemortMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service // service 안에 component가 포함 되어있음
//@Component // 컴포넌트 @가 있으면 스프링 컨테이너에 다 등록해놓음
// 스프링 빈에 자동등록 컴포넌트 시 @컨트롤러 @서비스 @레포지토리 다 자동 등록됨
@Transactional
public class MemberService {

    private final MemberRepositiry memberRepositiry;

    //Autowired
    public MemberService(MemberRepositiry memberRepositiry){
        this. memberRepositiry = memberRepositiry;
    } // 메모리 멤버 리포지토리를 넣어줌

    public Long join(Member member){ //회원가입
        //같은 이름 중복 x
        long start = System.currentTimeMillis();

        try{
        validateDuplicateMember(member);
        memberRepositiry.save(member);
        return member.getId();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join " + timeMs + "ms");

        }
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result =
                memberRepositiry.findByName(member.getName());
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findMembers(){
        long start = System.currentTimeMillis();

        try {
            return memberRepositiry.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    } // 전체회원조회

    public Optional<Member> findOne(Long memberId){
        return memberRepositiry.findById(memberId);
    }
}

