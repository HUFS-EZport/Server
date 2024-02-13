package com.example.ezports.domain.member.dto;

import com.example.ezports.domain.member.entity.MemberRole;
import com.example.ezports.domain.member.entity.MemberStatus;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMember {
        private Long id;
        private String email;
        private String nickname;
        private MemberStatus status;
        private MemberRole role;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class login {
        private Long memberId;
        private String accessToken;
        private String refreshToken;
        private String role;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getMember {
        private Long id;
        private String email;
        private MemberStatus status;
        private MemberRole role;
    }
}
