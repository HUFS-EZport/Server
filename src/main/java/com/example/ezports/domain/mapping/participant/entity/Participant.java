package com.example.ezports.domain.mapping.participant.entity;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "teamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @JoinColumn(name = "leagueId")
    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    public void updateParticipant(Team team, League league) {
        this.team = team;
        this.league = league;
    }
}
