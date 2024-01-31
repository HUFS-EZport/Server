package com.example.ezports.domain.league.controller;

import com.example.ezports.domain.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueService leagueService;

    @PostMapping
    public void createLeague() {
    }

    @GetMapping("/{leagueId}")
    public ResponseEntity getLeague(
            @PathVariable Long leagueId;
    ) {
    }

    @PutMapping("/{leagueId}")
    public void updateLeague(
            @PathVariable Long leagueId;
    ) {
    }

    @DeleteMapping("/{leagueId}")
    public void deleteLeague(
            @PathVariable Long leagueId;
    ) {
    }
}
