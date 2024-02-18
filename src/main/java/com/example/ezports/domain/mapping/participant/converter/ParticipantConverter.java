package com.example.ezports.domain.mapping.participant.converter;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantConverter {
    public Participant toParticipant(League league, Team team) {
        return Participant.builder()
                .league(league)
                .team(team)
                .build();
    }

    public List<TeamResponseDTO.getParticipantTeam> toGetParticipantTeam(List<Participant> participants) {
        return participants.stream()
                .map(participant -> TeamResponseDTO.getParticipantTeam.builder()
                        .id(participant.getTeam().getId())
                        .name(participant.getTeam().getName())
                        .logoUrl(participant.getTeam().getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }

    public List<LeagueResponseDTO.getLeagues> toGetLeagues(List<Participant> participants) {
        return participants.stream()
                .map(participant -> LeagueResponseDTO.getLeagues.builder()
                        .id(participant.getLeague().getId())
                        .name(participant.getLeague().getName())
                        .logoUrl(participant.getLeague().getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
