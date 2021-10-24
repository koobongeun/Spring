package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save하면 저장소에 저장이 됨
    Optional<Member> findByID(Long id); // 그 후 저장소에 id나 name으로 찾을 수 있음.
    Optional<Member> findByName(String name); // 그 후 저장소에 id나 name으로 찾을 수 있음.
    List<Member> findAll(); // 그동안 저장되어 있던 모든 정보를 리스트 형태로 반환 해준다.
}
