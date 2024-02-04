package com.example.ezports.domain.team.service;

import com.example.ezports.domain.team.entity.Team;
import com.example.ezports.domain.team.repository.TeamRepository;
import com.example.ezports.global.exception.GeneralException;
import com.example.ezports.global.exception.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamQueryService {
    private final TeamRepository teamRepository;

    public Team getTeam(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.TEAM_NOT_FOUND));
    }
}
