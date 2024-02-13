package com.example.ezports.domain.match.converter;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.match.entity.MatchStatus;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchConverter {

    public Match toMatch(League league, Team homeTeam, Team awayTeam, String location, LocalDateTime matchDate) {
        return Match.builder()
                .league(league)
                .location(location)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .homeTeamScore(0)
                .awayTeamScore(0)
                .matchStatus(MatchStatus.PENDING)
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
                .matchStatus(match.getMatchStatus())
                .build();
    }

    public MatchResponseDTO.getMatch toGetMatch(Match match) {
        return MatchResponseDTO.getMatch.builder()
                .id(match.getId())
                .leagueId(match.getLeague().getId())
                .homeTeamName(match.getHomeTeam().getName())
                .awayTeamName(match.getAwayTeam().getName())
                .homeTeamScore(match.getHomeTeamScore())
                .awayTeamScore(match.getAwayTeamScore())
                .location(match.getLocation())
                .matchDate(match.getMatchDate())
                .matchStatus(match.getMatchStatus())
                .streamingUrls(match.getStreamingUrls())
                .build();
    }

    public List<MatchResponseDTO.getLeagueMatch> toGetLeagueMatch(List<Match> matches) {
        return matches.stream()
                .map(match -> MatchResponseDTO.getLeagueMatch.builder()
                        .id(match.getId())
                        .homeTeamName(match.getHomeTeam().getName())
                        .awayTeamName(match.getAwayTeam().getName())
                        .homeTeamScore(match.getHomeTeamScore())
                        .awayTeamScore(match.getAwayTeamScore())
                        .matchDate(match.getMatchDate())
                        .matchStatus(match.getMatchStatus())
                        .build())
                .collect(Collectors.toList());
    }
}
