package com.example.ezports.domain.team.converter;

import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    public Team toTeam(String teamName, String information) {
        return Team.builder()
                .name(teamName)
                .information(information)
                .build();
    }

    public TeamResponseDTO.createTeam toCreateTeam(Team team) {
        return TeamResponseDTO.createTeam.builder()
                .id(team.getId())
                .name(team.getName())
                .information(team.getInformation())
                .build();
    }

    public TeamResponseDTO.getTeam toGetTeam(Team team) {
        return TeamResponseDTO.getTeam.builder()
                .id(team.getId())
                .name(team.getName())
                .information(team.getInformation())
                .build();
    }
}
