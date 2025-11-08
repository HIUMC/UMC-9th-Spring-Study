package hello.springspring.controller;

import hello.springspring.domain.Member;
import hello.springspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링빈 자동 등록
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService; //생성자
    } //멤버 서비스에 스프링 컨테이너에 있는 멤버 서비스랑 연결 시켜줌
        //  Dependency Injection
        // DI에는 생성자 주입, 필드에 오토와이어드 (필드주입), setter 주입
        // memberservice에 setter 생성 그 위에 @autowired 세터를 통해 주입
        //  setter 주입은 public으로 선언 되어야됨
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    } //templates에서 createMemberForm 찾음
    //form은 값을 입력할 수 있는 태그

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName((form.getName())); // getname 으로 꺼냄

        memberService.join(member);
        return "redirect:/";
    } //포스트맵핑은 폼에 넣어서 전달할때 get은 조회할때 주로 사용
    //url은 같지만 get이냐 post냐에 따라 다르게 작동
    // 값이 여기로 들ㅇㅓ옴 MemberForm의 setname에 입력된 값 들어감

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
