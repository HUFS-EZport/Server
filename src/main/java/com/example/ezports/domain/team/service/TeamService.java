package com.example.ezports.domain.team.service;

import com.example.ezports.domain.team.converter.TeamConverter;
import com.example.ezports.domain.team.dto.TeamRequestDTO;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.entity.Team;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamService {
    private final TeamCommandService teamCommandService;
    private final TeamQueryService teamQueryService;
    private final TeamConverter teamConverter;

    @Transactional
    public TeamResponseDTO.createTeam createTeam(TeamRequestDTO.createTeam request) {
        Team team = teamConverter.toTeam(request.getName(), request.getInformation());
        Team savedTeam = teamCommandService.createTeam(team);
        return teamConverter.toCreateTeam(savedTeam);
    }

    @Transactional
    public TeamResponseDTO.getTeam getTeam(Long teamId) {
        Team team = teamQueryService.getTeam(teamId);
        return teamConverter.toGetTeam(team);
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
