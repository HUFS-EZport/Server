package com.example.ezports.domain.team.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.sport.entity.Sport;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String information;

    private String logoUrl;

    @JoinColumn(name = "leagueId")
    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

//    @JoinColumn(name = "sportId")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Sport sport;

    public void updateTeam(String name, String information) {
        this.name = name;
        this.information = information;
    }

}
