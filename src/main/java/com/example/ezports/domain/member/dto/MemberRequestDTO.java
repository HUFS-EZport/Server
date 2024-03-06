package com.example.ezports.domain.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MemberRequestDTO {
    @Getter
    public static class createMember {
        private String email;
        private String password;
        private String nickname;
    }

    @Getter
    public static class login {
        private String email;
        private String password;
    }

    @Getter
    public static class reissue {
        private String refreshToken;
    }

    @Getter
    public static class changePassword {
        private String password;
    }
}
