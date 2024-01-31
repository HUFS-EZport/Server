package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.member.entity.MemberStatus;
import com.example.ezports.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandService {
    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public void withdraw(Member member) {
        member.updateStatus(MemberStatus.WITHDRAWAL);
    }
}
