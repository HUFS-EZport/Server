package com.example.ezports.domain.mapping.entity;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavouriteLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "leagueId")
    @ManyToOne(fetch = FetchType.LAZY)
    private League league;
}
