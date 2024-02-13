package com.example.ezports.domain.match.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private LocalDateTime matchDate;

    private Integer homeTeamScore;

    private Integer awayTeamScore;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

    @JoinColumn(name = "leagueId")
    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    @JoinColumn(name = "homeTeamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team homeTeam;

    @JoinColumn(name = "awayTeamId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team awayTeam;

    @Builder.Default
    @ElementCollection
    private List<String> streamingUrls = new ArrayList<>();

    public void updateMatch(String location, LocalDateTime matchDate) {
        this.location = location;
        this.matchDate = matchDate;
    }

    public void addStreamingUrl(String streamingUrl) {
        this.streamingUrls.add(streamingUrl);
    }

    public void updateStreamingUrls(List<String> streamingUrls) {
        this.streamingUrls = streamingUrls;
    }

}
