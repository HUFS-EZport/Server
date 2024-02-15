package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.member.repository.MemberRepository;
import com.example.ezports.global.exception.GeneralException;
import com.example.ezports.global.exception.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.MEMBER_NOT_FOUND));
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.MEMBER_NOT_FOUND));
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}
