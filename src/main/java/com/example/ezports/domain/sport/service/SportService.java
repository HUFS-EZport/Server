package com.example.ezports.domain.sport.service;

import com.example.ezports.domain.league.converter.LeagueConverter;
import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.league.service.LeagueQueryService;
import com.example.ezports.domain.mapping.participant.converter.ParticipantConverter;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.mapping.participant.service.ParticipantService;
import com.example.ezports.domain.sport.converter.SportConverter;
import com.example.ezports.domain.sport.dto.SportRequestDTO;
import com.example.ezports.domain.sport.dto.SportResponseDTO;
import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SportService {
    private final SportCommandService sportCommandService;
    private final SportQueryService sportQueryService;
    private final SportConverter sportConverter;
    private final LeagueQueryService leagueQueryService;
    private final ParticipantService participantService;
    private final LeagueConverter leagueConverter;
    private final ParticipantConverter participantConverter;

    @Transactional
    public SportResponseDTO.createSport createSport(SportRequestDTO.createSport request) {
        Sport sport = sportConverter.toSport(request.getName(), request.getImageUrl());
        Sport savedSport = sportCommandService.createSport(sport);
        return sportConverter.toCreateSport(savedSport);
    }

    @Transactional
    public List<SportResponseDTO.getSport> getSports() {
        List<Sport> sports = sportQueryService.getSports();
        return sportConverter.toGetSports(sports);
    }

    @Transactional
    public SportResponseDTO.getSportInfo getSportInfo(Long sportId) {
        Sport sport = sportQueryService.getSport(sportId);
        List<League> sportLeagues = leagueQueryService.getBySport(sport);
        List<LeagueResponseDTO.getLeagues> leagues = leagueConverter.toGetLeagues(sportLeagues);
        List<Participant> participants = participantService.getParticipants(sportLeagues.get(0));
        List<TeamResponseDTO.getParticipantTeam> teams = participantConverter.toGetParticipantTeam(participants);
        return sportConverter.toGetSportInfo(sport, teams, leagues);
    }

    @Transactional
    public void updateSport(Long sportId, SportRequestDTO.updateSport request) {
        Sport sport = sportQueryService.getSport(sportId);
        sport.updateSport(request.getName());
    }

    @Transactional
    public void deleteSport(Long sportId) {
        Sport sport = sportQueryService.getSport(sportId);
        sportCommandService.deleteSport(sport);
    }
}
