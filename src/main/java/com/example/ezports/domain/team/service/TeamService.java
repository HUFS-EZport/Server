package com.example.ezports.domain.team.service;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.league.service.LeagueQueryService;
import com.example.ezports.domain.mapping.favourite.service.FavouriteQueryService;
import com.example.ezports.domain.mapping.participant.converter.ParticipantConverter;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.mapping.participant.service.ParticipantService;
import com.example.ezports.domain.match.converter.MatchConverter;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.match.service.MatchQueryService;
import com.example.ezports.domain.member.auth.utils.MemberUtils;
import com.example.ezports.domain.team.converter.TeamConverter;
import com.example.ezports.domain.team.dto.TeamRequestDTO;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.entity.Team;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TeamService {
    private final TeamCommandService teamCommandService;
    private final TeamQueryService teamQueryService;
    private final TeamConverter teamConverter;
    private final LeagueQueryService leagueQueryService;
    private final ParticipantService participantService;
    private final ParticipantConverter participantConverter;
    private final FavouriteQueryService favouriteQueryService;
    private final MemberUtils memberUtils;
    private final MatchQueryService matchQueryService;
    private final MatchConverter matchConverter;

    @Transactional
    public TeamResponseDTO.createTeam createTeam(TeamRequestDTO.createTeam request) {
        League league = leagueQueryService.getLeague(request.getLeagueId());
        Team team = teamConverter.toTeam(request.getName(), request.getInformation(), league);
        Team savedTeam = teamCommandService.createTeam(team);
        Participant participant = Participant.builder()
                .team(savedTeam)
                .league(league)
                .build();
        participantService.createParticipant(participant);
        return teamConverter.toCreateTeam(savedTeam);
    }

    @Transactional
    public TeamResponseDTO.getTeam getTeam(Long teamId) {
        Long memberId = memberUtils.getCurrentMemberId();
        Team team = teamQueryService.getTeam(teamId);
        boolean isFavourite = favouriteQueryService.isFavouriteTeam(memberId, teamId);
        List<Participant> participants = participantService.getLeaguesByTeam(team);
        List<LeagueResponseDTO.getLeagues> leagues = participantConverter.toGetLeagues(participants);
        List<Match> matches = matchQueryService.getByTeam(team);
        List<MatchResponseDTO.getTeamMatch> teamMatches = matchConverter.toGetTeamMatch(matches);
        return teamConverter.toGetTeam(team, leagues, teamMatches, isFavourite);
    }

    @Transactional
    public void updateTeam(Long teamId, TeamRequestDTO.updateTeam request) {
        Team team = teamQueryService.getTeam(teamId);
        team.updateTeam(request.getName(), request.getInformation());
    }

    @Transactional
    public void deleteTeam(Long teamId) {
        Team team = teamQueryService.getTeam(teamId);
        teamCommandService.deleteTeam(team);
    }
}
