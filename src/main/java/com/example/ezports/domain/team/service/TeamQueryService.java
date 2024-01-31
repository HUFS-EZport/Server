package com.example.ezports.domain.team.service;

import com.example.ezports.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamQueryService {
    private final TeamRepository teamRepository;
}
