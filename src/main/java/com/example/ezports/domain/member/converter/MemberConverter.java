package com.example.ezports.domain.member.converter;

import com.example.ezports.domain.member.dto.MemberResponseDTO;
import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.member.entity.MemberRole;
import com.example.ezports.domain.member.entity.MemberStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class MemberConverter {

    public Member toMember(String email, String password, String nickname) {
        return Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .status(MemberStatus.ACTIVE)
                .role(MemberRole.ROLE_USER)
                .build();
    }

    public MemberResponseDTO.createMember toCreateMember(Member member) {
        return MemberResponseDTO.createMember.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .status(member.getStatus())
                .role(member.getRole())
                .build();
    }

    public MemberResponseDTO.getMember toGetMember(Member member) {
        return MemberResponseDTO.getMember.builder()
                .id(member.getId())
                .email(member.getEmail())
                .status(member.getStatus())
                .role(member.getRole())
                .build();
    }

    public List<MemberResponseDTO.getMember> toGetMembers(List<Member> members) {
        return members.stream()
                .map(this::toGetMember)
                .collect(Collectors.toList());
    }
}
