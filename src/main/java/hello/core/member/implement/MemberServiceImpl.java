package hello.core.member.implement;

import hello.core.member.Member;
import hello.core.member.repository.MemberService;

public class MemberServiceImpl implements MemberService {

    private  final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
