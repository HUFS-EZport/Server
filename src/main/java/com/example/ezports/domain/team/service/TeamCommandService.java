package com.example.ezports.domain.team.service;

import com.example.ezports.domain.team.entity.Team;
import com.example.ezports.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCommandService {
    private final TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }
}
