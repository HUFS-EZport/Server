package com.example.ezports.domain.league.controller;

import com.example.ezports.domain.league.dto.LeagueRequestDTO;
import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.service.LeagueService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueService leagueService;

    @PostMapping
    public ApiResponse<LeagueResponseDTO.createLeague> createLeague(
            @RequestBody LeagueRequestDTO.createLeague request
    ) {
        return ApiResponse.onSuccess(leagueService.createLeague(request));
    }

    @GetMapping("/{leagueId}")
    public ApiResponse<LeagueResponseDTO.getLeague> getLeague(
            @PathVariable Long leagueId
    ) {
        return ApiResponse.onSuccess(leagueService.getLeague(leagueId));
    }

    @GetMapping("/{leagueId}/teams")
    public void getTeams(
            @PathVariable Long leagueId
    ) {
    }

    @PutMapping("/{leagueId}")
    public ApiResponse updateLeague(
            @PathVariable Long leagueId,
            @RequestBody LeagueRequestDTO.updateLeague request
    ) {
        leagueService.updateLeague(leagueId, request);
        return ApiResponse.onSuccess("");
    }

    @DeleteMapping("/{leagueId}")
    public ApiResponse deleteLeague(
            @PathVariable Long leagueId
    ) {
        leagueService.deleteLeague(leagueId);
        return ApiResponse.onSuccess("");
    }
}
