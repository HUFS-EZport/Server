package com.example.ezports.domain.match.converter;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter {

    public Match toMatch(League league, Team homeTeam, Team awayTeam, String location, String matchDate) {
        return Match.builder()
                .league(league)
                .location(location)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .matchDate(matchDate)
                .build();
    }

    public MatchResponseDTO.createMatch toCreateMatch(Match match) {
        return MatchResponseDTO.createMatch.builder()
                .id(match.getId())
                .leagueId(match.getLeague().getId())
                .homeTeamName(match.getHomeTeam().getName())
                .awayTeamName(match.getAwayTeam().getName())
                .location(match.getLocation())
                .matchDate(match.getMatchDate())
                .build();
    }

    public MatchResponseDTO.getMatch toGetMatch(Match match) {
        return MatchResponseDTO.getMatch.builder()
                .id(match.getId())
                .leagueId(match.getLeague().getId())
                .homeTeamName(match.getHomeTeam().getName())
                .awayTeamName(match.getAwayTeam().getName())
                .location(match.getLocation())
                .matchDate(match.getMatchDate())
                .build();
    }
}
