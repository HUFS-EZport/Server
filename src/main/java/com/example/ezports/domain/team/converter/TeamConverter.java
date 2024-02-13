package com.example.ezports.domain.team.converter;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamConverter {

    public Team toTeam(String teamName, String information, League league) {
        return Team.builder()
                .name(teamName)
                .information(information)
                .league(league)
                .build();
    }

    public TeamResponseDTO.createTeam toCreateTeam(Team team) {
        return TeamResponseDTO.createTeam.builder()
                .id(team.getId())
                .name(team.getName())
                .information(team.getInformation())
                .build();
    }

    public TeamResponseDTO.getTeam toGetTeam(Team team, List<LeagueResponseDTO.getLeagues> leagues) {
        return TeamResponseDTO.getTeam.builder()
                .id(team.getId())
                .name(team.getName())
                .information(team.getInformation())
                .leagues(leagues)
                .build();
    }
}
