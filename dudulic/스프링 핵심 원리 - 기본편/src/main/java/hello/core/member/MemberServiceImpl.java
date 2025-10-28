package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
    public class OrderServiceImpl implements OrderService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DiscountPolicy discountPolicy;
    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
//            discountPolicy) {
//            this.memberRepository = memberRepository;
//            this.discountPolicy = discountPolicy;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public class MemberServiceImpl implements MemberService {
        private final MemberRepository memberRepository;
        //테스트 용도
        public MemberRepository getMemberRepository() {
            return memberRepository;
        }
    }
    public class OrderServiceImpl implements OrderService {
        private final MemberRepository memberRepository;
        //테스트 용도
        public MemberRepository getMemberRepository() {
            return memberRepository;
        }
    }
}