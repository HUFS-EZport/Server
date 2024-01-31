package com.example.ezports.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Enumerated(EnumType.STRING)
//    private LoginType loginType;
    private String email;
    private String password;
    private MemberRole role;

}
