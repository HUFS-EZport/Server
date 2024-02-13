package com.example.ezports.domain.member.auth.utils;

import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberUtils {
    private final MemberRepository memberRepository;

    public Long getCurrentMemberId() {
        return SecurityUtils.getCurrentMemberId();
    }

    public Optional<Member> getCurrentMember() {
        return memberRepository.findById(getCurrentMemberId());
    }
}
