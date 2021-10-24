package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // anotation 작성 후 스프링 컨테이너가 빈으로 관리 함, 스프링 빈을 등록하는 방법 : 컴포넌트 스캔 방법 사용, 기본적으로 싱글톤(유일하게 하나) 설정
public class MemberController {
    private final MemberService memberService;

    @Autowired // cotroller가 service의 필요를 눈치채서 service를 찾아 주입함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;  // 생성자 주입
    }

    @GetMapping("members/new")// 주로 조회할떄 사용
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new") // postmapping은 데이터를 join에 넣으려구 사용!
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
