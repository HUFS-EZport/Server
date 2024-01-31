package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.controller.MemberController;
import com.example.ezports.domain.member.converter.MemberConverter;
import com.example.ezports.domain.member.dto.MemberRequestDTO;
import com.example.ezports.domain.member.dto.MemberResponseDTO;
import com.example.ezports.domain.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberConverter memberConverter;

    @Transactional
    public MemberResponseDTO.createMember createMember(MemberRequestDTO.createMember request) {
        Member member = memberConverter.toMember(request.getEmail(), request.getPassword());
        Member savedMember = memberCommandService.createMember(member);
        return memberConverter.toCreateMember(savedMember);
    }

    @Transactional
    public MemberResponseDTO.getMember getMember(Long memberId) {
        Member member = memberQueryService.getMember(memberId);
        return memberConverter.toGetMember(member);
    }

    @Transactional
    public List<MemberResponseDTO.getMember> getMembers() {
        List<Member> members = memberQueryService.getMembers();
        return memberConverter.toGetMembers(members);
    }

    @Transactional
    public void changePassword(Long memberId, MemberRequestDTO.changePassword request) {
        Member member = memberQueryService.getMember(memberId);
        member.changePassword(request.getPassword());
    }

    @Transactional
    public void withdraw(Long memberId) {
        Member member = memberQueryService.getMember(memberId);
        memberCommandService.withdraw(member);
    }
}
