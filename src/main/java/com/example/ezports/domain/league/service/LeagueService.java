package com.example.ezports.domain.league.service;

import com.example.ezports.domain.league.converter.LeagueConverter;
import com.example.ezports.domain.league.dto.LeagueRequestDTO;
import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.mapping.participant.converter.ParticipantConverter;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.mapping.participant.service.ParticipantService;
import com.example.ezports.domain.match.converter.MatchConverter;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.match.service.MatchQueryService;
import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.sport.service.SportQueryService;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LeagueService {
    private final LeagueCommandService leagueCommandService;
    private final LeagueQueryService leagueQueryService;
    private final LeagueConverter leagueConverter;
    private final ParticipantConverter participantConverter;
    private final ParticipantService participantService;
    private final MatchQueryService matchQueryService;
    private final MatchConverter matchConverter;
    private final SportQueryService sportQueryService;

    @Transactional
    public LeagueResponseDTO.createLeague createLeague(LeagueRequestDTO.createLeague request) {
        Sport sport = sportQueryService.getSport(request.getSportId());
        League league = leagueConverter.toLeague(request.getName(), request.getInformation(), sport);
        League savedLeague = leagueCommandService.createLeague(league);
        return leagueConverter.toCreateLeague(savedLeague);
    }

    @Transactional
    public LeagueResponseDTO.getLeague getLeague(Long leagueId) {
        League league = leagueQueryService.getLeague(leagueId);
        List<Participant> participants = participantService.getParticipants(league);
        List<TeamResponseDTO.getParticipantTeam> teams = participantConverter.toGetParticipantTeam(participants);
        List<Match> matches = matchQueryService.getByLeague(league);
        List<MatchResponseDTO.getLeagueMatch> leagueMatches = matchConverter.toGetLeagueMatch(matches);
        return leagueConverter.toGetLeague(league,teams, leagueMatches);
    }

    @Transactional
    public void updateLeague(Long leagueId, LeagueRequestDTO.updateLeague request) {
        League league = leagueQueryService.getLeague(leagueId);
        league.updateLeague(request.getName(), request.getInformation());
    }

    @Transactional
    public void deleteLeague(Long leagueId) {
        League league = leagueQueryService.getLeague(leagueId);
        leagueCommandService.deleteLeague(league);
    }

}
