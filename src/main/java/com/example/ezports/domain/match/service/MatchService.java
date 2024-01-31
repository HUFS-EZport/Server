package com.example.ezports.domain.match.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.league.service.LeagueQueryService;
import com.example.ezports.domain.match.converter.MatchConverter;
import com.example.ezports.domain.match.dto.MatchRequestDTO;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.team.entity.Team;
import com.example.ezports.domain.team.service.TeamQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchService {
    private final MatchCommandService matchCommandService;
    private final MatchQueryService matchQueryService;
    private final LeagueQueryService leagueQueryService;
    private final TeamQueryService teamQueryService;
    private final MatchConverter matchConverter;

    @Transactional
    public MatchResponseDTO.createMatch createMatch(MatchRequestDTO.createMatch request) {
        League league = leagueQueryService.getLeague(request.getLeagueId());
        Team homeTeam = teamQueryService.getTeam(request.getHomeTeamId());
        Team awayTeam = teamQueryService.getTeam(request.getAwayTeamId());
        Match match = matchConverter.toMatch(league, homeTeam, awayTeam, request.getLocation(), request.getMatchDate());
        Match savedMatch = matchCommandService.createMatch(match);
        return matchConverter.toCreateMatch(savedMatch);
    }

    @Transactional
    public MatchResponseDTO.getMatch getMatch(Long matchId) {
        Match match = matchQueryService.getMatch(matchId);
        return matchConverter.toGetMatch(match);
    }

    @Transactional
    public void updateMatch(Long matchId, MatchRequestDTO.updateMatch request) {
        Match match = matchQueryService.getMatch(matchId);
        match.updateMatch(request.getLocation(), request.getMatchDate());
    }

    @Transactional
    public void deleteMatch(Long matchId) {
        Match match = matchQueryService.getMatch(matchId);
        matchCommandService.deleteMatch(match);
    }
}
