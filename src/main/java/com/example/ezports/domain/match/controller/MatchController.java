package com.example.ezports.domain.match.controller;

import com.example.ezports.domain.match.dto.MatchRequestDTO;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.service.MatchService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;


    @PostMapping
    public ApiResponse<MatchResponseDTO.createMatch> createMatch(
            @RequestBody MatchRequestDTO.createMatch request
    ) {
        return ApiResponse.onSuccess(matchService.createMatch(request));
    }

    @GetMapping("/{matchId}")
    public ApiResponse<MatchResponseDTO.getMatch> getMatch(
            @PathVariable Long matchId
    ) {
        return ApiResponse.onSuccess(matchService.getMatch(matchId));
    }

    @PutMapping("/{matchId}")
    public ApiResponse updateMatch(
            @PathVariable Long matchId,
            @RequestBody MatchRequestDTO.updateMatch request
    ) {
        matchService.updateMatch(matchId, request);
        return ApiResponse.onSuccess("");
    }

    @DeleteMapping("/{matchId}")
    public ApiResponse deleteMatch(
            @PathVariable Long matchId
    ) {
        matchService.deleteMatch(matchId);
        return ApiResponse.onSuccess("");
    }

}
