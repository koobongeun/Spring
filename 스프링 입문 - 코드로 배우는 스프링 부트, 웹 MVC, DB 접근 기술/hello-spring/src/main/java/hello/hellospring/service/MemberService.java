package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 스프링 빈을 등록하는 방법 : 컴포넌트 스캔 방법 사용, 기본적으로 싱글톤(유일하게 하나) 설정
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired // service가 repository의 필요를 눈치채서 repository를 찾아 주입함
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 생성자 주입
    }

    //
//    회원가입
//
    public long join(Member member){
        //같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //null 가능성을 없애기 위해 optional로 감싼다.
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원 입니다.");
             });
    }
    /**
     전체 회원 조회
      **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
