package com.example.ezports.domain.team.controller;

import com.example.ezports.domain.team.dto.TeamRequestDTO;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.example.ezports.domain.team.service.TeamService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public ApiResponse<TeamResponseDTO.createTeam> createTeam(
            @RequestBody TeamRequestDTO.createTeam request
    ) {
        return ApiResponse.onSuccess(teamService.createTeam(request));
    }


    @GetMapping("/{teamId}")
    public ApiResponse<TeamResponseDTO.getTeam> getTeam(
            @PathVariable Long teamId
    ) {
        return ApiResponse.onSuccess(teamService.getTeam(teamId));
    }


    @PutMapping("/{teamId}")
    public ApiResponse updateTeam(
            @PathVariable Long teamId,
            @RequestBody TeamRequestDTO.updateTeam request
    ) {
        teamService.updateTeam(teamId, request);
        return ApiResponse.onSuccess("");
    }

    @DeleteMapping("/{teamId}")
    public ApiResponse deleteTeam(
            @PathVariable Long teamId
    ) {
        teamService.deleteTeam(teamId);
        return ApiResponse.onSuccess("");
    }

}
