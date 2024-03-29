package com.example.ezports.domain.member.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated(EnumType.STRING)
//    private LoginType loginType;
    private String email;

    private String password;

    private String nickname;

    private MemberRole role;

    private MemberStatus status;

    public void updateStatus(MemberStatus status) {
        this.status = status;
    }

    public void changePassword(String password) {
        this.password = password;
    }

}
