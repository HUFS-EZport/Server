package com.example.ezports.domain.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamService {
    private final TeamCommandService teamCommandService;
    private final TeamQueryService teamQueryService;
}
