package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 안됨
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //기존이였다면 if null 이런식으로 했겠지만 Optional 이여서 가능한 것
        memberRepository.findByName(member.getName())
                .ifPresent(m->{ // Optional result 이렇게 하면 안이쁘므로 그냥 이렇게해서 사용가능
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
