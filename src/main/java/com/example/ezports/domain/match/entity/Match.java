package com.example.ezports.domain.match.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import com.example.ezports.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @JoinColumn(name = "homeTeamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team homeTeam;

    @JoinColumn(name = "awayTeamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team awayTeam;


}
