package com.example.ezports.domain.league.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeagueService {
    private final LeagueCommandService leagueCommandService;
    private final LeagueQueryService leagueQueryService;
}
