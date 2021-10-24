//package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* 자바코드로 직접 빈을 등록하는 방법
* MemberService가 memberRepository를 직접 참조
* 옛날엔는 xml로 설정하였는데 요즘에는 잘안쓰는 방법
*
* 정형화된 프로젝트일 경우는 컴포넌트스캔 방식을 사용하고 상황에 따라 구현 클래스를 변경해야 하면 설정을통해 스프링 빈으로 등록한다.
* */
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
