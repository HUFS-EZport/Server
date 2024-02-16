package com.example.ezports.domain.league.converter;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeagueConverter {
    public League toLeague(String leagueName, String information, Sport sport) {
        return League.builder()
                .name(leagueName)
                .information(information)
                .logoUrl("")
                .sport(sport)
                .build();
    }

    public LeagueResponseDTO.createLeague toCreateLeague(League league) {
        return LeagueResponseDTO.createLeague.builder()
                .id(league.getId())
                .name(league.getName())
                .information(league.getInformation())
                .build();
    }

    public LeagueResponseDTO.getLeague toGetLeague(League league, List<TeamResponseDTO.getParticipantTeam> teams, List<MatchResponseDTO.getLeagueMatch> matches, boolean isFavourite) {
        return LeagueResponseDTO.getLeague.builder()
                .id(league.getId())
                .name(league.getName())
                .information(league.getInformation())
                .logoUrl(league.getLogoUrl())
                .isFavourite(isFavourite)
                .teams(teams)
                .matches(matches)
                .build();
    }

    public List<LeagueResponseDTO.getLeagues> toGetLeagues(List<League> leagues) {
        return leagues.stream()
                .map(league -> LeagueResponseDTO.getLeagues.builder()
                        .id(league.getId())
                        .name(league.getName())
                        .logoUrl(league.getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }

}
